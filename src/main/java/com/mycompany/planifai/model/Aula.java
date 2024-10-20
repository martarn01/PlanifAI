package com.mycompany.planifai.model;

/**
 *
 * @author marta
 */
public class Aula {

    private int idAula;
    private String nombre;
    private String asignatura;

    public Aula(int idAula, String nombre, String asignatura) {
        this.idAula = idAula;
        this.nombre = nombre;
        this.asignatura = asignatura;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    
}
