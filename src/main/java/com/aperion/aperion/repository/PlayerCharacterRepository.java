package com.aperion.aperion.repository;

import com.aperion.aperion.model.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
//Long indica el id de la clave primaria
public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long> {
}
