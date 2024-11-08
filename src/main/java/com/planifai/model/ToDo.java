package com.planifai.model;

/**
 * Clase que representa una tarea (To-Do) en el sistema. Cada tarea está
 * asociada a un aula y tiene un estado de completado.
 *
 * @author Marta Rosado Nabais
 */
public class ToDo {

    private int idToDo;
    private String descripcion;
    private boolean completado;
    private int idAula;  // Debe estar asociado a un aula
    private Aula aula;

    /**
     * Constructor por defecto de la clase ToDo.
     */
    public ToDo() {
    }

    /**
     * Constructor de la clase ToDo.
     *
     * @param idToDo ID único de la tarea.
     * @param descripcion Descripción de la tarea.
     * @param completado Estado de completado de la tarea.
     * @param idAula ID del aula asociado a la tarea, debe estar asociado a un
     * aula.
     * @param aula Objeto Aula asociado a la tarea.
     */
    public ToDo(int idToDo, String descripcion, boolean completado, int idAula, Aula aula) {
        this.idToDo = idToDo;
        this.descripcion = descripcion;
        this.completado = completado;
        this.idAula = idAula;
        this.aula = aula;
    }

    public int getIdToDo() {
        return idToDo;
    }

    public void setIdToDo(int idToDo) {
        this.idToDo = idToDo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
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
