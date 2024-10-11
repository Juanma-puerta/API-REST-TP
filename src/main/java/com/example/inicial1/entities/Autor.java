package com.example.inicial1.entities;

import jakarta.persistence.Column;

public class Autor extends Base {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name="biografia", length = 1500)
    private String biografia;
}

