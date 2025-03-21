package com.aperion.aperion.service;

import com.aperion.aperion.model.PlayerCharacter;
import com.aperion.aperion.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerCharacterService {

    @Autowired
    private PlayerCharacterRepository playerCharacterRepository;

    // Crear un nuevo personaje
    public PlayerCharacter createPlayerCharacter(PlayerCharacter playerCharacter) {
        // Si no se proporcionan acciones, inicializa el conjunto de acciones como vacío
        if (playerCharacter.getActions() == null) {
            playerCharacter.setActions(new HashSet<>());
        }

        // Establecer atributos predeterminados si no se proporcionan
        if (playerCharacter.getStrength() == 0) playerCharacter.setStrength(0);
        if (playerCharacter.getAgility() == 0) playerCharacter.setAgility(0);
        if (playerCharacter.getConstitution() == 0) playerCharacter.setConstitution(0);
        if (playerCharacter.getDexterity() == 0) playerCharacter.setDexterity(0);
        if (playerCharacter.getIntelligence() == 0) playerCharacter.setIntelligence(0);
        if (playerCharacter.getPerception() == 0) playerCharacter.setPerception(0);
        if (playerCharacter.getWisdom() == 0) playerCharacter.setWisdom(0);
        if (playerCharacter.getCharisma() == 0) playerCharacter.setCharisma(0);

        // Guarda el personaje en la base de datos
        return playerCharacterRepository.save(playerCharacter);
    }


    // Obtener todos los personajes
    public List<PlayerCharacter> getAllPlayerCharacters() {
        return playerCharacterRepository.findAll();
    }

    // Obtener un personaje por su ID
    public PlayerCharacter getPlayerCharacterById(Long id) {
        return playerCharacterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlayerCharacter not found"));
    }


    // Actualizar un personaje existente
    public PlayerCharacter updatePlayerCharacter(Long id, PlayerCharacter updatedPlayerCharacter) {
        PlayerCharacter existingPlayerCharacter = playerCharacterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlayerCharacter not found"));

        existingPlayerCharacter.setName(updatedPlayerCharacter.getName());
        existingPlayerCharacter.setLevel(updatedPlayerCharacter.getLevel());
        existingPlayerCharacter.setAttributePoints(updatedPlayerCharacter.getAttributePoints());

        return playerCharacterRepository.save(existingPlayerCharacter);
    }


    // Eliminar un personaje por su ID
    public void deletePlayerCharacter(Long id) {
        PlayerCharacter existingPlayerCharacter = playerCharacterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlayerCharacter not found"));
        playerCharacterRepository.delete(existingPlayerCharacter);
    }


    // Obtener personajes por nombre
    public List<PlayerCharacter> getPlayerCharacterByName(String name) {
        return playerCharacterRepository.findByName(name);
    }
}
