package com.guigasauro.teamdraftmanagementsys.api;

import com.guigasauro.teamdraftmanagementsys.domain.Team;
import com.guigasauro.teamdraftmanagementsys.exception.ResourceNotFoundException;
import com.guigasauro.teamdraftmanagementsys.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("team")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public List<Team> getAll(){

        List <Team> list = teamRepository.findAll();

        return list;
    }

    @PostMapping
    public ResponseEntity<Team> save(@RequestBody Team team){
        Team saved = teamRepository.save(team);

        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getById(@PathVariable Long id){
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Team not found with ID: " + id)
        );

        return ResponseEntity.ok(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> update(
            @PathVariable Long id,
            @RequestBody Team details){

        Team team = teamRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Team not found with ID: " + id)
        );

        team.setId(details.getId());
        team.setUserId(details.getUserId());
        team.setTeamName(details.getTeamName());

        Team updated = teamRepository.save(team);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete (@PathVariable Long id){
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Team not found with ID: " + id)
        );

        teamRepository.delete(team);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
