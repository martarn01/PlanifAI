package com.mycompany.planifai.model;

/**
 *
 * @author marta
 */
public class SituacionAprendizaje {

    private int idSituacion;
    private String titulo;
    private String descripcion;
    private int idAula;        // Debe estar asociado a un aula
    private Integer idEvento;  // Puede ser null
    
    // Relación Muchos a Uno con Aula
    private Aula aula;

    public SituacionAprendizaje(int idSituacion, String titulo, String descripcion, int idAula, Integer idEvento, Aula aula) {
        this.idSituacion = idSituacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.idAula = idAula;
        this.idEvento = idEvento;
        this.aula = aula;
    }

    public int getIdSituacion() {
        return idSituacion;
    }

    public void setIdSituacion(int idSituacion) {
        this.idSituacion = idSituacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
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

}
