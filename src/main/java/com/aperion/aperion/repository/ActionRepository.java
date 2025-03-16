package com.aperion.aperion.repository;
import com.aperion.aperion.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ActionRepository extends JpaRepository<Action, Long>{
}
