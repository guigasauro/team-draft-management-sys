package com.guigasauro.teamdraftmanagementsys.domain;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "PLAYERS")
@Entity(name = "PLAYER")
@Data
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String realTeam;
    private Integer overall;
    private String position1;
    private String position2;
    private String position3;
    private String position4;
    private Integer teamId;
}
