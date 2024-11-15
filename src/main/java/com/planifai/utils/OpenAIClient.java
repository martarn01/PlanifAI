package com.planifai.utils;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Clase OpenAIClient para interactuar con la API de OpenAI y enviar prompts.
 * Esta clase permite enviar solicitudes a la API de OpenAI utilizando el modelo GPT y 
 * recibir respuestas generadas. La autenticación se gestiona a través de una clave de API 
 * almacenada como variable de entorno.
 * 
 * @author Marta Rosado Nabais
 */
public class OpenAIClient {

    private static String apiKey = System.getenv("OPENAI_API_KEY");
    private static final String API_KEY = apiKey;
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    private OkHttpClient client;

    public OpenAIClient() {
        client = new OkHttpClient();
    }

    /**
     * Envía un prompt a la API de OpenAI y recibe la respuesta.
     *
     * @param prompt El texto del prompt a enviar.
     * @return La respuesta generada por OpenAI.
     * @throws IOException Si ocurre un error durante la solicitud HTTP.
     */
    public String obtenerRespuesta(String prompt) throws IOException {
        // Crear el cuerpo de la solicitud
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("model", "gpt-3.5-turbo");
        JSONArray messages = new JSONArray();
        messages.put(new JSONObject().put("role", "user").put("content", prompt));
        jsonBody.put("messages", messages);

        RequestBody body = RequestBody.create(jsonBody.toString(), MediaType.parse("application/json"));

        // Crear la solicitud
        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        // Enviar la solicitud y recibir la respuesta
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseData = response.body().string();
                JSONObject jsonResponse = new JSONObject(responseData);

                // Obtener la respuesta generada por el modelo
                JSONArray choices = jsonResponse.getJSONArray("choices");
                StringBuilder responseText = new StringBuilder();
                for (int i = 0; i < choices.length(); i++) {
                    JSONObject choice = choices.getJSONObject(i);
                    String content = choice.getJSONObject("message").getString("content");
                    responseText.append(content).append("\n");
                }
                return responseText.toString();
            } else {
                throw new IOException("Error en la respuesta de la API: " + response.message());
            }
        }
    }
}
