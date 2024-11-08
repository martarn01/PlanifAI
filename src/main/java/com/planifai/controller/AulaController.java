package com.planifai.controller;

import com.planifai.model.Aula;
import com.planifai.service.AulaService;
import java.util.List;

/**
 * Controlador para gestionar las aulas en la aplicación.
 * Este controlador actúa como intermediario entre la vista y el servicio de aulas,
 * manejando las solicitudes de la vista y delegando la lógica de negocio al AulaService.
 * 
 * @author marta rosado nabais
 */
public class AulaController {

    private AulaService aulaService;

    /**
     * Constructor del AulaController que inicializa el servicio de aulas.
     *
     * @param aulaService Servicio que maneja la lógica de negocio relacionada con las aulas.
     */
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    /**
     * Obtiene un aula por su identificador único.
     *
     * @param idAula El identificador del aula a obtener.
     * @return El objeto Aula correspondiente al identificador proporcionado,
     *         o null si no se encuentra el aula.
     */
    public Aula getAulaById(int idAula) {
        return aulaService.getAulaById(idAula);
    }

    /**
     * Obtiene una lista de todas las aulas disponibles.
     *
     * @return Una lista de objetos Aula que representan todas las aulas.
     */
    public List<Aula> obtenerAulas() {
        return aulaService.getAulas();
    }

    /**
     * Crea una nueva aula con los datos proporcionados.
     *
     * @param nombre El nombre del aula a crear.
     * @param asignatura La asignatura asociada al aula.
     */
    public void crearAula(String nombre, String asignatura) {
        aulaService.crearAula(nombre, asignatura);
    }

    /**
     * Elimina un aula por su identificador único.
     *
     * @param aulaId El identificador del aula a eliminar.
     * @return true si el aula fue eliminada con éxito, false en caso contrario.
     */
    public boolean eliminarAula(int aulaId) {
        return aulaService.eliminarAulaPorId(aulaId);
    }
}
