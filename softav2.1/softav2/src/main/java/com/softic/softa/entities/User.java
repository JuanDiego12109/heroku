package com.softic.softa.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "auth0id", unique = true)
    private String auth0id;

    public User(String email, String image, String auth0id) {
        this.email = email;
        this.image = image;
        this.auth0id = auth0id;
    }
}
