package com.planifai.controller;

import com.planifai.model.Aula;
import com.planifai.service.AulaService;
import java.util.List;

/**
 *
 * @author marta
 */
public class AulaController {

    private AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    public List<Aula> obtenerAulas() {
        return aulaService.getAulas();
    }

    public void agregarAula(Aula aula) {
        aulaService.crearAula(aula.getNombre(), aula.getAsignatura());// Método que debes implementar en DatabaseService para agregar aulas.
    }

    public boolean eliminarAula(int aulaId) {
        return aulaService.eliminarAulaPorId(aulaId);
    }
}
