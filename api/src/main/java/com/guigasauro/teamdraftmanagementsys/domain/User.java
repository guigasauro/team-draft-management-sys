package com.guigasauro.teamdraftmanagementsys.domain;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "USERS")
@Entity(name = "USER")
@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
}
