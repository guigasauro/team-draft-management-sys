package com.guigasauro.teamdraftmanagementsys.api;

import com.guigasauro.teamdraftmanagementsys.domain.User;
import com.guigasauro.teamdraftmanagementsys.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private UserRepository repository;
    @GetMapping
    public void getAll(){
        List<User> userList =

    }
}
