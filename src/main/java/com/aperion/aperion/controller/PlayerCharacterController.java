package com.aperion.aperion.controller;

import com.aperion.aperion.model.PlayerCharacter;
import com.aperion.aperion.service.PlayerCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/characters")
public class PlayerCharacterController {

    @Autowired
    private PlayerCharacterService playerCharacterService;

    // Obtener todos los personajes
    @GetMapping
    public List<PlayerCharacter> getAllPlayerCharacters() {
        return playerCharacterService.getAllPlayerCharacters();
    }

    // Obtener un personaje por ID
    @GetMapping("/{id}")
    public PlayerCharacter getPlayerCharacterById(@PathVariable Long id) {
        return playerCharacterService.getPlayerCharacterById(id);
    }

    // Crear un personaje nuevo
    @PostMapping
    public ResponseEntity<PlayerCharacter> createPlayerCharacter(@RequestBody PlayerCharacter playerCharacter) {
        // Llama al servicio que ya maneja la lógica de establecer valores predeterminados
        PlayerCharacter createdPlayerCharacter = playerCharacterService.createPlayerCharacter(playerCharacter);
        return new ResponseEntity<>(createdPlayerCharacter, HttpStatus.CREATED);
    }


    // Actualizar un personaje existente
    @PutMapping("/{id}")
    public PlayerCharacter updatePlayerCharacter(@PathVariable Long id, @RequestBody PlayerCharacter playerCharacter) {
        return playerCharacterService.updatePlayerCharacter(id, playerCharacter);
    }

    // Eliminar un personaje
    @DeleteMapping("/{id}")
    public void deletePlayerCharacter(@PathVariable Long id) {
        playerCharacterService.deletePlayerCharacter(id);
    }
}
