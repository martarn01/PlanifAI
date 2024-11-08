package com.planifai.model;

/**
 * Clase que representa una situación de aprendizaje en el sistema. Una
 * situación de aprendizaje está asociada a un aula y puede estar relacionada
 * con un evento.
 *
 * @author Marta Rosado Nabais
 */
public class SituacionAprendizaje {

    private int idSituacion;
    private String titulo;
    private String descripcion;
    private int idAula;        // Debe estar asociado a un aula
    private Integer idEvento;  // Puede ser null
    private Aula aula; // Relación Muchos a Uno con Aula

    /**
     * Constructor por defecto de la clase SituacionAprendizaje.
     */
    public SituacionAprendizaje() {
    }

    /**
     * Constructor de la clase SituacionAprendizaje.
     *
     * @param idSituacion ID único de la situación de aprendizaje.
     * @param titulo Título de la situación de aprendizaje.
     * @param descripcion Descripción de la situación de aprendizaje.
     * @param idAula ID del aula asociado a la situación de aprendizaje, debe
     * estar asociado a un aula.
     * @param idEvento ID del evento asociado a la situación de aprendizaje,
     * puede ser null.
     * @param aula Objeto Aula asociado a la situación de aprendizaje.
     */
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
