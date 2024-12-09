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

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    /**
     * Crea un nuevo evento con los datos proporcionados.
     *
     * @param descripcion Descripción del evento
     * @param fechaEvento Fecha y hora del evento
     * @param tipoEvento Tipo de evento
     * @param idAula ID del aula asociada
     * @param idDocumento ID del documento asociado (puede ser null)
     */
    public void crearEvento(String descripcion, Timestamp fechaEvento, String tipoEvento, int idAula, Integer idDocumento) {
        eventoService.crearEvento(descripcion, fechaEvento, tipoEvento, idAula, idDocumento);
    }

    /**
     * Actualiza un evento existente.
     *
     * @param idEvento ID del evento a actualizar
     * @param descripcion Nueva descripción del evento
     * @param fechaEvento Nueva fecha y hora del evento
     * @param tipoEvento Nuevo tipo de evento
     * @param idAula ID del aula asociada
     * @param idDocumento ID del documento asociado (puede ser null)
     * @return true si el evento fue actualizado con éxito, false en caso
     * contrario
     */
    public boolean actualizarEvento(int idEvento, String descripcion,
            Timestamp fechaEvento, String tipoEvento,
            int idAula, Integer idDocumento) {
        return eventoService.actualizarEvento(idEvento, descripcion, fechaEvento,
                tipoEvento, idAula, idDocumento);
    }

    /**
     * Obtiene los eventos asociados a un aula específica.
     *
     * @param idAula ID del aula
     * @return Lista de eventos asociados al aula
     */
    public List<Evento> obtenerEventosPorAula(int idAula) {
        return eventoService.obtenerEventosPorAula(idAula);
    }

    /**
     * Elimina un evento por su ID.
     *
     * @param idEvento ID del evento a eliminar
     * @return true si el evento fue eliminado con éxito, false en caso
     * contrario
     */
    public boolean eliminarEvento(int idEvento) {
        return eventoService.eliminarEventoPorId(idEvento);
    }

    /**
     * Obtiene todos los eventos disponibles.
     *
     * @return Lista de todos los eventos
     */
    public List<Evento> obtenerEventos() {
        return eventoService.obtenerEventos();
    }

    /**
     * Actualiza un evento existente con los nuevos datos proporcionados.
     *
     * Este método delega la actualización del evento en el servicio
     * `EventoService`. Utiliza el ID del evento para identificar el evento a
     * actualizar y realiza la modificación de los siguientes campos:
     * descripción, fecha, tipo de evento, ID del aula y ID del documento (si se
     * proporciona uno).
     *
     * @param idEvento El ID del evento a actualizar. Este parámetro es
     * obligatorio para identificar el evento en la base de datos.
     * @param descripcion La nueva descripción del evento. Este parámetro no
     * puede ser nulo ni vacío.
     * @param fechaEvento La nueva fecha y hora del evento. Este parámetro debe
     * ser un valor de tipo `Timestamp`.
     * @param tipoEvento El nuevo tipo de evento. Este parámetro no puede ser
     * nulo.
     * @param idAula El ID del aula asociada al evento. Este parámetro debe ser
     * un valor válido que corresponda a un aula existente en el sistema.
     * @param idDocumento El ID del documento asociado al evento, puede ser nulo
     * si el evento no tiene documento asociado.
     * @return `true` si la actualización del evento fue exitosa, `false` en
     * caso contrario (por ejemplo, si la base de datos no pudo actualizar el
     * evento).
     */
    public boolean editarEvento(int idEvento, String descripcion, Timestamp fechaEvento,
            String tipoEvento, int idAula, Integer idDocumento) {
        return eventoService.actualizarEvento(idEvento, descripcion, fechaEvento, tipoEvento, idAula, idDocumento);
    }

}
