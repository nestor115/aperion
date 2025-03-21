package com.aperion.aperion.repository;

import com.aperion.aperion.model.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
//Long indica el id de la clave primaria
public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long> {
    List<PlayerCharacter> findByName(String name);
}
