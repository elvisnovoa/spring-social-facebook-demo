package com.everis.sample.persistence;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "USER")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;
}
