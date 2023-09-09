package com.guigasauro.teamdraftmanagementsys.repository;

import com.guigasauro.teamdraftmanagementsys.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
