package com.aperion.aperion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evita la serialización infinita
    private Set<PlayerCharacterAttribute> playerCharacterAttributes;
    public Attribute() {}

    public Attribute(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PlayerCharacterAttribute> getPlayerCharacterAttributes() {
        return playerCharacterAttributes;
    }

    public void setPlayerCharacterAttributes(Set<PlayerCharacterAttribute> playerCharacterAttributes) {
        this.playerCharacterAttributes = playerCharacterAttributes;
    }

}
