package com.guigasauro.teamdraftmanagementsys.domain;

import lombok.Data;

@Data
public class Player {
    Long id;
    String name;
    Integer age;
    String realTeam;
    Integer overall;
    String[] positions;
}
