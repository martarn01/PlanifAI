package com.planifai.controller;

import com.planifai.model.Evento;
import com.planifai.service.EventoService;
import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador para manejar las operaciones relacionadas con los eventos. Este
 * controlador actúa como intermediario entre la vista y el servicio de eventos.
 *
 * Marta Rosado Nabais
 */
public class EventoController {

    private EventoService eventoService;

    /**
     * Constructor de la clase EventoController.
     *
     * @param eventoService Instancia del servicio de eventos.
     */
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    /**
     * Obtiene un evento por su ID.
     *
     * @param idEvento ID del evento a obtener.
     * @return Evento objeto que representa el evento encontrado, o null si no
     * se encuentra.
     */
    public Evento getEventoById(int idEvento) {
        return eventoService.getEventoById(idEvento);
    }

    /**
     * Obtiene una lista de todos los eventos.
     *
     * @return List<Evento> Lista de eventos.
     */
    public List<Evento> obtenerEventos() {
        return eventoService.getEventos();
    }

    /**
     * Crea un nuevo evento utilizando el servicio de eventos.
     *
     * @param descripcion Descripción del evento.
     * @param fechaEvento Fecha y hora del evento.
     * @param tipoEvento Tipo de evento.
     * @param idAula ID del aula asociado al evento.
     * @param idDocumento ID del documento asociado al evento, puede ser null.
     */
    public void crearEvento(String descripcion, Timestamp fechaEvento, String tipoEvento, int idAula) {
        eventoService.crearEvento(descripcion, fechaEvento, tipoEvento, idAula);
    }

    /**
     * Elimina un evento por su ID.
     *
     * @param idEvento ID del evento a eliminar.
     * @return true si el evento fue eliminado con éxito, false en caso
     * contrario.
     */
    public boolean eliminarEvento(int idEvento) {
        return eventoService.eliminarEventoPorId(idEvento);
    }

    /**
     * Actualiza la información de un evento existente.
     *
     * @param idEvento ID del evento a actualizar.
     * @param descripcion Nueva descripción del evento.
     * @param fechaEvento Nueva fecha y hora del evento.
     * @param tipoEvento Nuevo tipo de evento.
     * @param idAula Nuevo ID del aula asociado al evento.
     * @param idDocumento Nuevo ID del documento asociado al evento, puede ser
     * null.
     * @return true si el evento fue actualizado con éxito, false en caso
     * contrario.
     */
    public boolean actualizarEvento(int idEvento, String descripcion, Timestamp fechaEvento, String tipoEvento, int idAula) {
        return eventoService.actualizarEvento(idEvento, descripcion, fechaEvento, tipoEvento, idAula);
    }
    public List<Evento> obtenerEventosPorAula(int idAula) {
    return eventoService.obtenerEventosPorAula(idAula);
}

}
