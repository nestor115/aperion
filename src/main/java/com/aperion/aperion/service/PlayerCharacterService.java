package com.aperion.aperion.service;

import com.aperion.aperion.model.PlayerCharacter;
import com.aperion.aperion.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerCharacterService {

    @Autowired
    private PlayerCharacterRepository playerCharacterRepository;

    //Devuelve todos los personajes
    public List<PlayerCharacter> getAllPlayerCharacters() {
        return playerCharacterRepository.findAll();
    }
    //Devuelve un personaje filtrando por id
    public PlayerCharacter getPlayerCharacterById(Long id) {
        return playerCharacterRepository.findById(id).orElseThrow(() -> new RuntimeException("PlayerCharacter not found"));
    }
    // Crear un nuevo personaje
    public PlayerCharacter createPlayerCharacter(PlayerCharacter playerCharacter) {
        return playerCharacterRepository.save(playerCharacter);
    }

    // Actualizar personaje
    public PlayerCharacter updatePlayerCharacter(Long id, PlayerCharacter updatedCharacter) {
        PlayerCharacter existingCharacter = playerCharacterRepository.findById(id).orElseThrow(() -> new RuntimeException("PlayerCharacter not found"));
        existingCharacter.setName(updatedCharacter.getName());
        existingCharacter.setLevel(updatedCharacter.getLevel());
        existingCharacter.setAttributePoints(updatedCharacter.getAttributePoints());
        return playerCharacterRepository.save(existingCharacter);
    }

    // Eliminar personaje
    public void deletePlayerCharacter(Long id) {
        PlayerCharacter character = playerCharacterRepository.findById(id).orElseThrow(() -> new RuntimeException("PlayerCharacter not found"));
        playerCharacterRepository.delete(character);
    }
}
