package com.aperion.aperion.repository;

import com.aperion.aperion.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
