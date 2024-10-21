package com.mycompany.planifai.model;

import java.util.List;

/**
 *
 * @author marta
 */
public class Aula {

    private int idAula;
    private String nombre;
    private String asignatura;
   
    private List<Evento> eventos; // Relación Uno a Muchos con Evento
    private List<Documento> Documento; // Relación Uno a Muchos con documentos
    private List<SituacionAprendizaje> situacionesAprendizaje; // Relación Uno a Muchos con SituacionAprendizaje

    public Aula(int idAula, String nombre, String asignatura, List<Evento> eventos, List<Documento> Documento, List<SituacionAprendizaje> situacionesAprendizaje) {
        this.idAula = idAula;
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.eventos = eventos;
        this.Documento = Documento;
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
        return Documento;
    }

    public void setDocumento(List<Documento> Documento) {
        this.Documento = Documento;
    }

    
}
