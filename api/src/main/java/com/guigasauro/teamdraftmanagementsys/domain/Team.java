package com.guigasauro.teamdraftmanagementsys.domain;

import lombok.Data;

@Data
public class Team {
    Long id;
    String name;
    Player[] players;
}
