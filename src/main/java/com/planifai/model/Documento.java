package com.planifai.model;

import java.sql.Timestamp;

/**
 * Clase que representa un documento en el sistema. Un documento puede estar
 * asociado a un aula, un evento y una situación de aprendizaje.
 *
 * @author Marta Rosado Nabais
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
    
    /**
     * Constructor por defecto de la clase Documento.
     */
    public Documento() {
    }

    /**
     * Constructor de la clase Documento.
     *
     * @param idDocumento ID único del documento.
     * @param titulo Título del documento.
     * @param contenido Contenido del documento.
     * @param fechaCreacion Fecha de creación del documento.
     * @param tipoDocumento Tipo del documento (ej. PDF, Word, etc.).
     * @param idAula ID del aula asociado al documento, puede ser null si no
     * está asociado.
     * @param idEvento ID del evento asociado al documento, puede ser null si no
     * está asociado.
     * @param aula Objeto Aula asociado al documento.
     * @param evento Objeto Evento asociado al documento.
     */
    public Documento(int idDocumento, String titulo, String contenido, Timestamp fechaCreacion, String tipoDocumento, Integer idAula, Integer idEvento, Aula aula, Evento evento) {
        this.idDocumento = idDocumento;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.tipoDocumento = tipoDocumento;
        this.idAula = idAula;
        this.idEvento = idEvento;
        this.aula = aula;
        this.evento = evento;
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

}
