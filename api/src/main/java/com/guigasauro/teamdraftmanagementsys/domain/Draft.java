package com.guigasauro.teamdraftmanagementsys.domain;

import lombok.Data;

@Data
public class Draft {
    Long id;
    Team[] teamsDrawn;
    Player[] eligiblePlayers;
    // method 0 = random (default), 1 = draft selection.
    Integer method = 0;
}
