package com.aperion.aperion.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "player_character")
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int level;
    private int attributePoints;

    // Atributos
    private int strength;
    private int agility;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int perception;
    private int wisdom;
    private int charisma;



    //@JsonIgnoreProperties("actions")
    // Relación muchos a muchos con Action
    @ManyToMany
    @JoinTable(
            name = "player_character_actions",
            joinColumns = @JoinColumn(name = "player_character_id"),
            inverseJoinColumns = @JoinColumn(name = "action_id")
    )
    //@JsonManagedReference // Evita el bucle en la serialización
    private Set<Action> actions = new HashSet<>();

    public PlayerCharacter() {}

    public PlayerCharacter(String name, int level, int attributePoints, int strength, int agility, int constitution,
                           int dexterity, int intelligence, int perception, int wisdom, int charisma) {
        this.name = name;
        this.level = level;
        this.attributePoints = attributePoints;
        this.strength = strength;
        this.agility = agility;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.perception = perception;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }
}
