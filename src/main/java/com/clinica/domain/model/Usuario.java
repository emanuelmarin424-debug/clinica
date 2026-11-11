package com.clinica.domain.model;

public abstract class Usuario {

    private Long id;
    private String nombre;
    private String correo;
    private String rol;

    public Usuario(Long id, String nombre, String correo, String rol) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("El correo no es valido");
        }
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }
}
