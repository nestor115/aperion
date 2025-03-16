package com.aperion.aperion.controller;

import com.aperion.aperion.model.Attribute;
import com.aperion.aperion.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    // Obtener todos los atributos
    @GetMapping
    public List<Attribute> getAllAttributes() {
        return attributeService.getAllAttributes();
    }

    // Obtener un atributo por ID
    @GetMapping("/{id}")
    public Attribute getAttributeById(@PathVariable Long id) {
        return attributeService.getAttributeById(id);
    }

    // Crear un nuevo atributo
    @PostMapping
    public Attribute createAttribute(@RequestBody Attribute attribute) {
        return attributeService.createAttribute(attribute);
    }

    // Actualizar un atributo existente
    @PutMapping("/{id}")
    public Attribute updateAttribute(@PathVariable Long id, @RequestBody Attribute attribute) {
        return attributeService.updateAttribute(id, attribute);
    }

    // Eliminar un atributo
    @DeleteMapping("/{id}")
    public void deleteAttribute(@PathVariable Long id) {
        attributeService.deleteAttribute(id);
    }
}
