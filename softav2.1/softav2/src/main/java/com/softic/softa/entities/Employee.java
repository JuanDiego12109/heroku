package com.softic.softa.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
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
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "employee")
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //Clave primaria

    //Atributos
    @Column(name = "name")
    private String name;
    private String email;
    private String telefono;

//    @Column(name = "enterprise_employee")
//    private String enterpriseEmployee;
    //private String role;

    //RELACION DE TABLAS

    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id") //key Foranea
    private Profile profile;

    //@Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Rol rol;

    //RELACION DE TABLAS
    //Relacion de tablas Employee - Enterprise
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "enterprise_id", insertable = false, updatable = false ) // No insertar ni modificar nada en la tabla enterprise, enterprise_id es la llave foranea
//    private Enterprise enterprise;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id") //Entidad Employee es la propietaria, ya que Enterprise tiene mappedBy
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Enterprise enterprise;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();

    //updateAt y createdAt
    @CreationTimestamp
    private LocalDateTime fcreateAt; // fecha de Creacion

    @UpdateTimestamp
    private LocalDateTime fupdatedAt; // fecha de actualizacion





}


