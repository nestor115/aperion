package com.aperion.aperion.service;

import com.aperion.aperion.model.Action;
import com.aperion.aperion.model.PlayerCharacter;
import com.aperion.aperion.repository.ActionRepository;
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

    @Autowired
    private ActionRepository actionRepository;

    // Crear un nuevo personaje
    public PlayerCharacter createPlayerCharacter(PlayerCharacter playerCharacter) {
        // Si no se proporcionan acciones, inicializa el conjunto de acciones como vacío
        if (playerCharacter.getActions() == null) {
            playerCharacter.setActions(new HashSet<>());
        }

        // Asegúrate de que cada acción tiene un nombre, si no lo tiene, asignarlo desde la base de datos o crear uno nuevo
        for (Action action : playerCharacter.getActions()) {
            if (action.getName() == null) {
                // Asignar el nombre de la acción si es necesario, podrías buscarlo en la base de datos
                Action existingAction = actionRepository.findById(action.getId()).orElse(null);
                if (existingAction != null) {
                    action.setName(existingAction.getName());
                } else {
                    action.setName("Nombre Predeterminado");
                }
            }
        }
        // Establecer atributos predeterminados si no se proporcionan
        playerCharacter.setDefaultAttributes(playerCharacter);

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
