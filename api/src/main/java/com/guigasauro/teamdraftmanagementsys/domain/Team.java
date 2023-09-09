package com.guigasauro.teamdraftmanagementsys.domain;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "TEAMS")
@Entity(name = "TEAM")
@Data
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String teamName;
}
