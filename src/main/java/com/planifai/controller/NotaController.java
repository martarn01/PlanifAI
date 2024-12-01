package com.planifai.controller;

import com.planifai.service.NoteService;
import java.sql.Timestamp;

/**
 *
 * @author marta
 */
public class NotaController {

    private NoteService noteService;

    public NotaController(NoteService noteService) {
        this.noteService = noteService;
    }

  
    public void crearNota(String contenido, int idAula) {
        noteService.crearNota(contenido, idAula);
    }

    public String obtenerNotaPorAula(int idAula) {
        return noteService.obtenerNotaPorAula(idAula);
    }
}
