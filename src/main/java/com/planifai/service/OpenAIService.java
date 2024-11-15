package com.planifai.service;

import com.planifai.utils.OpenAIClient;
import java.io.IOException;

/**
 * Servicio para interactuar con la API de OpenAI, usando un cliente de OpenAI
 * para generar documentos basados en prompts de entrada.
 *
 * @author Marta Rosado Nabais
 */
public class OpenAIService {

    private OpenAIClient openAIClient;

    /**
     * Constructor que inicializa el cliente de OpenAI.
     */
    public OpenAIService() {
        openAIClient = new OpenAIClient();

    }

    /**
     * Llama a la API de OpenAI para generar el documento basado en el prompt.
     *
     * @param prompt El texto que se quiere enviar a la API.
     * @return La respuesta generada por OpenAI.
     */
    public String generarDocumento(String prompt) {
        try {
            return openAIClient.obtenerRespuesta(prompt);
        } catch (IOException e) {
            e.printStackTrace();
            return "Hubo un error al generar el documento.";
        }
    }
}
