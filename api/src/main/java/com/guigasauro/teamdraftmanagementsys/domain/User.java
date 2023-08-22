package com.guigasauro.teamdraftmanagementsys.domain;

import lombok.Data;

@Data
public class User {
    Long id;
    String name;
    String username;
    String password;
    Team[] userTeams;
}
