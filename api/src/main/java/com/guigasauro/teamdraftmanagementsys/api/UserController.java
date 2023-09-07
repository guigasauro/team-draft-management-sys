package com.guigasauro.teamdraftmanagementsys.api;


import com.guigasauro.teamdraftmanagementsys.domain.User;
import com.guigasauro.teamdraftmanagementsys.exception.ResourceNotFoundException;
import com.guigasauro.teamdraftmanagementsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAll(){

        List<User> list = userRepository.findAll();
        return list;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User saved = userRepository.save(user);

        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found with ID: " + id)
        );

        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable Long id,
            @RequestBody User details){

        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found with ID: " + id)
        );

        user.setId(details.getId());
        user.setName(details.getName());
        user.setUsername(details.getUsername());
        user.setPassword(details.getPassword());

        User updated = userRepository.save(user);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found with ID: " + id)
        );

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
