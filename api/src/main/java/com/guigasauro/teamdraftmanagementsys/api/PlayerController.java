package com.guigasauro.teamdraftmanagementsys.api;

import com.guigasauro.teamdraftmanagementsys.domain.Player;
import com.guigasauro.teamdraftmanagementsys.exception.ResourceNotFoundException;
import com.guigasauro.teamdraftmanagementsys.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("player")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getAll(){

        List <Player> list = playerRepository.findAll();
        return list;
    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player){
        Player saved = playerRepository.save(player);

        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id){
        Player player = playerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Player not found with ID: " + id)
        );

        return ResponseEntity.ok(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> update(
            @PathVariable Long id,
            @RequestBody Player details){

        Player player = playerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found with ID: " + id)
        );

        player.setId(details.getId());
        player.setPlayerName(details.getPlayerName());
        player.setAge(details.getAge());
        player.setRealTeam(details.getRealTeam());
        player.setOverall(details.getOverall());
        player.setPosition1(details.getPosition1());
        player.setPosition2(details.getPosition2());
        player.setPosition3(details.getPosition3());
        player.setPosition4(details.getPosition4());
        player.setTeamId(details.getTeamId());

        Player updated = playerRepository.save(player);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id){
        Player player = playerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Player not found with ID: " + id)
        );

        playerRepository.delete(player);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
