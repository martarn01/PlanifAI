package com.planifai.model;

import java.util.ArrayList;
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
    private List<Evento> eventos;
    private List<Documento> documentos;

    public Aula() {
    }

    /**
     * Constructor de la clase Aula que inicializa todos los atributos.
     *
     * @param idAula Identificador único de la aula
     * @param nombre Nombre de la aula
     * @param asignatura Asignatura asociada a la aula
     */
    public Aula(int idAula, String nombre, String asignatura) {
        this.idAula = idAula;
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.eventos = new ArrayList<>();
        this.documentos = new ArrayList<>();
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

    public List<Documento> getDocumento() {
        return documentos;
    }

    public void setDocumento(List<Documento> Documentos) {
        this.documentos = Documentos;
    }
    
     // Métodos de dominio específicos
    public void agregarEvento(Evento evento) {
        if (eventos == null) {
            eventos = new ArrayList<>();
        }
        eventos.add(evento);
        evento.setIdAula(this.idAula);
    }
    
    public void removerEvento(Evento evento) {
        if (eventos != null) {
            eventos.remove(evento);
        }
    }
    
    public void agregarDocumento(Documento documento) {
        if (documentos == null) {
            documentos = new ArrayList<>();
        }
        documentos.add(documento);
        documento.setIdAula(this.idAula);
    }
    
    public void removerDocumento(Documento documento) {
        if (documentos != null) {
            documentos.remove(documento);
        }
    }
}
