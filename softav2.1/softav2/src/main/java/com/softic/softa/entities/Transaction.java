package com.softic.softa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor //Al modelar las clases como entidades hay que tener un constructor vacío para evitar errores a futuro.
@Getter
@Setter
@ToString
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Atributos
    @Column(name = "concept_movements")
    private String conceptMovements;
    @Column(name = "amount_movements")
    private float amountMovements;

    //RELACION DE TABLAS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Enterprise enterprise;

    //updateAt y createdAt
    @CreationTimestamp
    private LocalDateTime fcreateAt; // fecha de Creacion

    @UpdateTimestamp
    private LocalDateTime fupdatedAt; // fecha de actualizacion

}
