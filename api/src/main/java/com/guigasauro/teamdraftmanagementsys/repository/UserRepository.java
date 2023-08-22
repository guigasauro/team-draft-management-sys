package com.guigasauro.teamdraftmanagementsys.repository;

import com.guigasauro.teamdraftmanagementsys.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
