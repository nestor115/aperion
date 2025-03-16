package com.aperion.aperion.repository;

import com.aperion.aperion.model.PlayerCharacterAttribute;
import com.aperion.aperion.model.PlayerCharacterAttributeId;
import com.aperion.aperion.model.PlayerCharacterAttributeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerCharacterAttributeRepository extends JpaRepository<PlayerCharacterAttribute, PlayerCharacterAttributeKey> {

}