package com.example.lab8_20192270.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Local implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "latitud")
    private String latitud;
    @Basic
    @Column(name = "longitud")
    private String longitud;
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;


}
