package com.aperion.aperion.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlayerCharacterAttributeKey implements Serializable {

    @Column(name = "player_character_id")
    private Long playerCharacterId;

    @Column(name = "attribute_id")
    private Long attributeId;

    public PlayerCharacterAttributeKey() {}

    public PlayerCharacterAttributeKey(Long playerCharacterId, Long attributeId) {
        this.playerCharacterId = playerCharacterId;
        this.attributeId = attributeId;
    }

    public Long getPlayerCharacterId() {
        return playerCharacterId;
    }

    public void setPlayerCharacterId(Long playerCharacterId) {
        this.playerCharacterId = playerCharacterId;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCharacterAttributeKey that = (PlayerCharacterAttributeKey) o;
        return Objects.equals(playerCharacterId, that.playerCharacterId) &&
                Objects.equals(attributeId, that.attributeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerCharacterId, attributeId);
    }
}

