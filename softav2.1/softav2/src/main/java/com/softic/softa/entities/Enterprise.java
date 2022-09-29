package com.softic.softa.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor //Al modelar las clases como entidades hay que tener un constructor vacío para evitar errores a futuro.
@Getter
@Setter
@ToString
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Atributos
    @Column(name = "nombre")
    private String nombre;
    private String nit;
    private String telefono;
    private String direccion;

    //RELACION DE TABLAS
    //Relacion de tablas Enterprise y Employee
    @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();

    //updateAt y createdAt
    @CreationTimestamp
    private LocalDateTime fcreateAt; // fecha de Creacion

    @UpdateTimestamp
    private LocalDateTime fupdatedAt; // fecha de actualizacion

}