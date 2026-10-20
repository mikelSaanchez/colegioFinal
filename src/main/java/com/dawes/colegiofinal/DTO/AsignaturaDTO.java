package com.dawes.colegiofinal.DTO;

public class AsignaturaDTO {
    private String id;
    private String nombre;
    private String curso;
    private double tasa;
    private int activo;

    public AsignaturaDTO(String id, String nombre, String curso, double tasa, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.tasa = tasa;
        this.activo = activo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
