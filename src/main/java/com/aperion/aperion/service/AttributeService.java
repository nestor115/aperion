package com.aperion.aperion.service;

import com.aperion.aperion.model.Attribute;
import com.aperion.aperion.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    //Devuelve todos los atributos
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }
    //Devuelve un atributo filtrando por id
    public Attribute getAttributeById(Long id) {
        return attributeRepository.findById(id).orElseThrow(() -> new RuntimeException("Attribute not found"));
    }
    // Crear un nuevo atributo
    public Attribute createAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    // Actualizar atributo
    public Attribute updateAttribute(Long id, Attribute updatedAttribute) {
        Attribute existingAttribute = attributeRepository.findById(id).orElseThrow(() -> new RuntimeException("Attribute not found"));
        existingAttribute.setName(updatedAttribute.getName());
        return attributeRepository.save(existingAttribute);
    }

    // Eliminar atributo
    public void deleteAttribute(Long id) {
        Attribute attribute = attributeRepository.findById(id).orElseThrow(() -> new RuntimeException("Attribute not found"));
        attributeRepository.delete(attribute);
    }
}
