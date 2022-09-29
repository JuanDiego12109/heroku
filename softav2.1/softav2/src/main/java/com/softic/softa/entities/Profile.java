package com.softic.softa.entities;

import lombok.*;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    //Atributos
    private Long id;
    private String image;
    private String phone;

    //RELACION DE TABLAS
    @OneToOne
    private Employee employee;

    //updateAt y createdAt
    @CreationTimestamp
    private LocalDateTime fcreateAt; // fecha de Creacion

    @UpdateTimestamp
    private LocalDateTime fupdatedAt; // fecha de actualizacion



}
