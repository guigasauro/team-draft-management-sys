package com.guigasauro.teamdraftmanagementsys.repository;

import com.guigasauro.teamdraftmanagementsys.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}