package com.aperion.aperion.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "player_character")
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int level;
    private int attributePoints;

    @OneToMany(mappedBy = "playerCharacter", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Evita la recursión infinita
    private Set<PlayerCharacterAttribute> attributes;

    public PlayerCharacter() {}
    public PlayerCharacter(String name, int level, int attributePoints) {
        this.name = name;
        this.level = level;
        this.attributePoints = attributePoints;
    }
    // Relación muchos a muchos con Action
    @ManyToMany
    @JoinTable(
            name = "player_character_actions",
            joinColumns = @JoinColumn(name = "player_character_id"),
            inverseJoinColumns = @JoinColumn(name = "action_id")
    )
    @JsonManagedReference // Evita el bucle en la serialización
    private Set<Action> actions ;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttributePoints() {
        return attributePoints;
    }

    public void setAttributePoints(int attributePoints) {
        this.attributePoints = attributePoints;
    }

    public Set<PlayerCharacterAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<PlayerCharacterAttribute> attributes) {
        this.attributes = attributes;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }
}
