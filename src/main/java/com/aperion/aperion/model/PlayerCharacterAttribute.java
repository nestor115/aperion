package com.aperion.aperion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "player_character_attributes")
public class PlayerCharacterAttribute {
    @EmbeddedId
    private PlayerCharacterAttributeKey id;

    @ManyToOne
    @MapsId("playerCharacterId")
    @JoinColumn(name = "player_character_id")
    @JsonBackReference // Evita la serialización infinita
    private PlayerCharacter playerCharacter;

    @ManyToOne
    @MapsId("attributeId")
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    private int value;

    public PlayerCharacterAttribute() {}

    public PlayerCharacterAttribute(PlayerCharacter playerCharacter, Attribute attribute, int value) {
        this.id = new PlayerCharacterAttributeKey(playerCharacter.getId(), attribute.getId());
        this.playerCharacter = playerCharacter;
        this.attribute = attribute;
        this.value = value;
    }

    public PlayerCharacterAttributeKey getId() {
        return id;
    }

    public void setId(PlayerCharacterAttributeKey id) {
        this.id = id;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
