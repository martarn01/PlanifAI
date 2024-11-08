package com.planifai.model;

import java.util.List;

/**
 * La clase Aula representa un aula en la aplicación PlanifAI. Contiene
 * información sobre el aula, incluyendo su identificación, nombre, asignatura y
 * las relaciones con eventos, documentos y situaciones de aprendizaje.
 *
 * @author marta rosado nabais
 */
public class Aula {

    private int idAula;
    private String nombre;
    private String asignatura;
    private List<Evento> eventos; // Relación Uno a Muchos con Evento
    private List<Documento> Documentos; // Relación Uno a Muchos con documentos
    private List<SituacionAprendizaje> situacionesAprendizaje; // Relación Uno a Muchos con SituacionAprendizaje

    public Aula() {
    }

    /**
     * Constructor de la clase Aula que inicializa todos los atributos.
     *
     * @param idAula Identificador único de la aula
     * @param nombre Nombre de la aula
     * @param asignatura Asignatura asociada a la aula
     * @param eventos Lista de eventos asociados a la aula
     * @param Documento Lista de documentos asociados a la aula
     * @param situacionesAprendizaje Lista de situaciones de aprendizaje
     * asociadas a la aula
     */
    public Aula(int idAula, String nombre, String asignatura, List<Evento> eventos, List<Documento> Documento, List<SituacionAprendizaje> situacionesAprendizaje) {
        this.idAula = idAula;
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.eventos = eventos;
        this.Documentos = Documento;
        this.situacionesAprendizaje = situacionesAprendizaje;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<SituacionAprendizaje> getSituacionesAprendizaje() {
        return situacionesAprendizaje;
    }

    public void setSituacionesAprendizaje(List<SituacionAprendizaje> situacionesAprendizaje) {
        this.situacionesAprendizaje = situacionesAprendizaje;
    }

    public List<Documento> getDocumento() {
        return Documentos;
    }

    public void setDocumento(List<Documento> Documentos) {
        this.Documentos = Documentos;
    }
}
