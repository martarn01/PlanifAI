package com.planifai.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Clase que representa un evento en el sistema. Cada evento está asociado a un
 * aula y puede tener documentos relacionados.
 *
 * @author Marta Rosado Nabais
 */
public class Evento {

    private int idEvento;
    private String descripcion;
    private Timestamp fechaEvento;
    private String tipoEvento;
    private int idAula;      // Debe estar asociado a un aula
    private Integer idDocumento; // Puede ser nullprivate 
    Aula aula;
    List<Documento> documentos;  // Relación Uno a Muchos con Documento

    /**
     * Constructor por defecto de la clase Evento.
     */
    public Evento() {
    }

    /**
     * Constructor de la clase Evento.
     *
     * @param idEvento ID único del evento.
     * @param descripcion Descripción del evento.
     * @param fechaEvento Fecha y hora del evento.
     * @param tipoEvento Tipo de evento.
     * @param idAula ID del aula asociado al evento, debe estar asociado a un
     * aula.
     * @param idDocumento ID del documento asociado al evento, puede ser null.
     * @param aula Objeto Aula asociado al evento.
     * @param documentos Lista de documentos relacionados con el evento.
     */
    public Evento(int idEvento, String descripcion, Timestamp fechaEvento, String tipoEvento, int idAula, Integer idDocumento, Aula aula, List<Documento> documentos) {
        this.idEvento = idEvento;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.tipoEvento = tipoEvento;
        this.idAula = idAula;
        this.idDocumento = idDocumento;
        this.aula = aula;
        this.documentos = documentos;
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

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

}
