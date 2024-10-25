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
    
    Aula aula;

    public ToDo() {
    }

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
