package com.aperion.aperion.service;

import com.aperion.aperion.model.*;
import com.aperion.aperion.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerCharacterAttributeService {

    @Autowired
    private PlayerCharacterAttributeRepository playerCharacterAttributeRepository;

    @Autowired
    private PlayerCharacterRepository playerCharacterRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    // Asignar un atributo a un personaje
    public PlayerCharacterAttribute assignAttribute(Long playerCharacterId, Long attributeId, int value) {
        PlayerCharacter playerCharacter = playerCharacterRepository.findById(playerCharacterId)
                .orElseThrow(() -> new RuntimeException("PlayerCharacter not found"));

        Attribute attribute = attributeRepository.findById(attributeId)
                .orElseThrow(() -> new RuntimeException("Attribute not found"));

        PlayerCharacterAttribute newAttribute = new PlayerCharacterAttribute(playerCharacter, attribute, value);
        return playerCharacterAttributeRepository.save(newAttribute);
    }

    // Obtener todos los atributos de un personaje
    public List<PlayerCharacterAttribute> getAttributesByPlayerCharacter(Long playerCharacterId) {
        return playerCharacterAttributeRepository.findAll().stream()
                .filter(attr -> attr.getPlayerCharacter().getId().equals(playerCharacterId))
                .toList();
    }

    // Actualizar el valor de un atributo de un personaje
    public PlayerCharacterAttribute updateAttributeValue(Long playerCharacterId, Long attributeId, int newValue) {
        PlayerCharacterAttributeKey key = new PlayerCharacterAttributeKey(playerCharacterId, attributeId);
        PlayerCharacterAttribute existingAttribute = playerCharacterAttributeRepository.findById(key)
                .orElseThrow(() -> new RuntimeException("PlayerCharacterAttribute not found"));

        existingAttribute.setValue(newValue);
        return playerCharacterAttributeRepository.save(existingAttribute);
    }

    // Eliminar un atributo de un personaje
    public void removeAttribute(Long playerCharacterId, Long attributeId) {
        PlayerCharacterAttributeKey key = new PlayerCharacterAttributeKey(playerCharacterId, attributeId);
        PlayerCharacterAttribute attribute = playerCharacterAttributeRepository.findById(key)
                .orElseThrow(() -> new RuntimeException("PlayerCharacterAttribute not found"));
        playerCharacterAttributeRepository.delete(attribute);
    }
}
