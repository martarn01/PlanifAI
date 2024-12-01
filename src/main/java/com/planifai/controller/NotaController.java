package com.planifai.controller;

import com.planifai.service.NoteService;

/**
 * Controlador para la gestión de notas.
 * Esta clase maneja las operaciones relacionadas con las notas, como la creación y recuperación de notas asociadas a un aula.
 * Utiliza la clase {@link NoteService} para interactuar con la capa de servicio.
 * 
 * @author Marta Rosado Nabais
 */
public class NotaController {

    private NoteService noteService;

    /**
     * Constructor de la clase NotaController.
     * Inicializa el controlador con el servicio de notas proporcionado.
     * 
     * @param noteService Instancia de {@link NoteService} utilizada para interactuar con la lógica de negocio relacionada con las notas.
     */
    public NotaController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Crea una nueva nota para un aula específico.
     * 
     * @param contenido El contenido de la nota que se desea crear.
     * @param idAula El identificador del aula asociado a la nota.
     */
    public void crearNota(String contenido, int idAula) {
        noteService.crearNota(contenido, idAula);
    }

    /**
     * Recupera la nota asociada a un aula específico.
     * 
     * @param idAula El identificador del aula para la cual se desea obtener la nota.
     * @return El contenido de la nota asociada al aula especificada. Si no existe una nota para el aula, retorna null o un valor predeterminado.
     */
    public String obtenerNotaPorAula(int idAula) {
        return noteService.obtenerNotaPorAula(idAula);
    }
}
