package com.planifai.controller;

import com.planifai.service.OpenAIService;

/**
 * OpenAIController gestiona las interacciones con el servicio de OpenAI.
 * Recibe prompts y envía solicitudes para obtener respuestas generadas por IA.
 * Esta clase encapsula la lógica de solicitud para centralizar el acceso a OpenAI.
 */
public class OpenAIController {


    private OpenAIService openAIService;

    /**
     * Constructor que inicializa el servicio de OpenAI.
     */
    public OpenAIController() {
        openAIService = new OpenAIService();
    }

    /**
     * Envía un prompt al servicio de OpenAI y obtiene una respuesta generada.
     *
     * @param prompt El texto del prompt a enviar.
     * @return La respuesta generada por OpenAI.
     */
    public String obtenerRespuestaDeOpenAI(String prompt) {
        return openAIService.generarDocumento(prompt);
    }
}
