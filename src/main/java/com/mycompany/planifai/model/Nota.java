package com.mycompany.planifai.model;

import java.sql.Timestamp;

/**
 *
 * @author marta
 */
public class Nota {

    private int idNota;
    private String contenido;
    private Timestamp fechaCreacion;
    private int idAula;  // Debe estar asociado a un aula
    
    Aula aula;

    public Nota() {
    }

    public Nota(int idNota, String contenido, Timestamp fechaCreacion, int idAula, Aula aula) {
        this.idNota = idNota;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.idAula = idAula;
        this.aula = aula;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
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

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
    
     
}
