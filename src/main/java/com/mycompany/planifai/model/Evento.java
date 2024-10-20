package com.mycompany.planifai.model;

import java.sql.Timestamp;

/**
 *
 * @author marta
 */
public class Evento {

    private int idEvento;
    private String descripcion;
    private Timestamp fechaEvento;
    private String tipoEvento;
    private int idAula;      // Debe estar asociado a un aula
    private Integer idDocumento; // Puede ser null

    public Evento(int idEvento, String descripcion, Timestamp fechaEvento, String tipoEvento, int idAula, Integer idDocumento) {
        this.idEvento = idEvento;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.tipoEvento = tipoEvento;
        this.idAula = idAula;
        this.idDocumento = idDocumento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Timestamp fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }
    
    
}

