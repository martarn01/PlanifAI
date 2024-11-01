package com.planifai.controller;

import com.planifai.model.Aula;
import com.planifai.service.AulaService;
import java.util.List;

/**
 *
 * @author marta
 */
public class AulaController {

    private AulaService databaseService;

    public AulaController(AulaService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Aula> obtenerAulas() {
        return databaseService.getAulas();
    }

    public void agregarAula(Aula aula) {
        databaseService.crearAula(aula.getNombre(), aula.getAsignatura());// Método que debes implementar en DatabaseService para agregar aulas.
    }

    public void eliminarAula(int aulaId) {
       // Implementa este método en DatabaseService.
    }
}
