package com.aperion.aperion.controller;

import com.aperion.aperion.model.PlayerCharacterAttribute;
import com.aperion.aperion.service.PlayerCharacterAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters/{playerCharacterId}/attributes")
public class PlayerCharacterAttributeController {

    @Autowired
    private PlayerCharacterAttributeService playerCharacterAttributeService;

    // Obtener todos los atributos de un personaje
    @GetMapping
    public List<PlayerCharacterAttribute> getAttributes(@PathVariable Long playerCharacterId) {
        return playerCharacterAttributeService.getAttributesByPlayerCharacter(playerCharacterId);
    }

    // Asignar un nuevo atributo a un personaje
    @PostMapping("/{attributeId}")
    public PlayerCharacterAttribute assignAttribute(
            @PathVariable Long playerCharacterId,
            @PathVariable Long attributeId,
            @RequestParam int value) {
        return playerCharacterAttributeService.assignAttribute(playerCharacterId, attributeId, value);
    }

    // Actualizar el valor de un atributo de un personaje
    @PutMapping("/{attributeId}")
    public PlayerCharacterAttribute updateAttribute(
            @PathVariable Long playerCharacterId,
            @PathVariable Long attributeId,
            @RequestParam int value) {
        return playerCharacterAttributeService.updateAttributeValue(playerCharacterId, attributeId, value);
    }

    // Eliminar un atributo de un personaje
    @DeleteMapping("/{attributeId}")
    public void removeAttribute(@PathVariable Long playerCharacterId, @PathVariable Long attributeId) {
        playerCharacterAttributeService.removeAttribute(playerCharacterId, attributeId);
    }
}

