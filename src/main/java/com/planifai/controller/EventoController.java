package com.planifai.controller;

import com.planifai.service.EventoService;

/**
 *
 * @author marta
 */
public class EventoController {

    private EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    // Método para eliminar un evento por ID
    public boolean eliminarEvento(int idEvento) {
        return eventoService.eliminarEventoPorId(idEvento);
    }
    
}
