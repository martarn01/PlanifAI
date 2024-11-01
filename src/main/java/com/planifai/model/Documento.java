package com.planifai.model;

import java.sql.Timestamp;

/**
 *
 * @author marta
 */
public class Documento {

    private int idDocumento;
    private String titulo;
    private String contenido;
    private Timestamp fechaCreacion;
    private String tipoDocumento;
    private Integer idAula;  // Puede ser null si no está asociado a un aula
    private Integer idEvento; // Puede ser null si no está asociado a un evento
    private Aula aula;  // Relación con Aula
    private Evento evento;  // Relación con Evento
    private SituacionAprendizaje situacionAprendizaje;  // Relación con SituacionAprendizaje

    public Documento() {
    }

    public Documento(int idDocumento, String titulo, String contenido, Timestamp fechaCreacion, String tipoDocumento, Integer idAula, Integer idEvento, Aula aula, Evento evento, SituacionAprendizaje situacionAprendizaje) {
        this.idDocumento = idDocumento;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.tipoDocumento = tipoDocumento;
        this.idAula = idAula;
        this.idEvento = idEvento;
        this.aula = aula;
        this.evento = evento;
        this.situacionAprendizaje = situacionAprendizaje;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public SituacionAprendizaje getSituacionAprendizaje() {
        return situacionAprendizaje;
    }

    public void setSituacionAprendizaje(SituacionAprendizaje situacionAprendizaje) {
        this.situacionAprendizaje = situacionAprendizaje;
    }

    
}
