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

    // Método para obtener un aula por ID
    public Aula getAulaById(int idAula) {
        return aulaService.getAulaById(idAula);
    }

    public List<Aula> obtenerAulas() {
        return aulaService.getAulas();
    }

    public void crearAula(String nombre, String asignatura) {
        aulaService.crearAula(nombre, asignatura);
        // Notificar o hacer otra gestión adicional si es necesario
    }

    public boolean eliminarAula(int aulaId) {
        return aulaService.eliminarAulaPorId(aulaId);
    }
}
