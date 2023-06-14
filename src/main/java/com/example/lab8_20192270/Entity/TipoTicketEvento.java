package com.example.lab8_20192270.Entity;

import com.example.lab8_20192270.Repository.TipoTicketRepo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "tipo_ticket_evento", schema = "lahaces", catalog = "")
public class TipoTicketEvento implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "precio")
    private String precio;
    @Basic
    @Column(name = "cantidad")
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento idEvento;

}
