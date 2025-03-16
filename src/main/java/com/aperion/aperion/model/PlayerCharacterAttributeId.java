package com.aperion.aperion.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlayerCharacterAttributeId implements Serializable {
    private Long playerCharacter;
    private Long attribute;

    public PlayerCharacterAttributeId() {}

    public PlayerCharacterAttributeId(Long playerCharacter, Long attribute) {
        this.playerCharacter = playerCharacter;
        this.attribute = attribute;
    }

    public Long getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(Long playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public Long getAttribute() {
        return attribute;
    }

    public void setAttribute(Long attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCharacterAttributeId that = (PlayerCharacterAttributeId) o;
        return Objects.equals(playerCharacter, that.playerCharacter) &&
                Objects.equals(attribute, that.attribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerCharacter, attribute);
    }
}
