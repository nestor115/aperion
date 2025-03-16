package com.aperion.aperion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int actionPoints;

    // Relación muchos a muchos con PlayerCharacter
    @ManyToMany(mappedBy = "actions")
    @JsonBackReference // Evita que se serialicen las referencias recursivas
    private Set<PlayerCharacter> characters = new HashSet<>();

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

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public Set<PlayerCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<PlayerCharacter> characters) {
        this.characters = characters;
    }
}
