package com.planifai.model;

import java.sql.Timestamp;

/**
 * Clase que representa una nota en el sistema. Una nota está asociada a un aula
 * específica.
 *
 * @author Marta Rosado Nabais
 */
public class Nota {

    private int idNota;
    private String contenido;
    private Timestamp fechaCreacion;
    private int idAula;  // Debe estar asociado a un aula
    private Aula aula;

    /**
     * Constructor por defecto de la clase Nota.
     */
    public Nota() {
    }

    /**
     * Constructor de la clase Nota.
     *
     * @param idNota ID único de la nota.
     * @param contenido Contenido de la nota.
     * @param fechaCreacion Fecha de creación de la nota.
     * @param idAula ID del aula asociado a la nota, debe estar asociado a un
     * aula.
     * @param aula Objeto Aula asociado a la nota.
     */
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
