package com.mycompany.planifai.model;

/**
 *
 * @author marta
 */
public class ToDo {

    private int idToDo;
    private String descripcion;
    private boolean completado;
    private int idAula;  // Debe estar asociado a un aula

    public ToDo(int idToDo, String descripcion, boolean completado, int idAula) {
        this.idToDo = idToDo;
        this.descripcion = descripcion;
        this.completado = completado;
        this.idAula = idAula;
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
    
    
    
}
