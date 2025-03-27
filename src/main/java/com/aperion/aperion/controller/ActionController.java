package com.aperion.aperion.controller;

import com.aperion.aperion.model.Action;
import com.aperion.aperion.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/actions")
public class ActionController {

    @Autowired
    private ActionService actionService;

    // Obtener todas las acciones
    @GetMapping
    public List<Action> getAllActions() {
        return actionService.getAllActions();
    }

    // Obtener una acción por ID
    @GetMapping("/{id}")
    public Action getActionById(@PathVariable Long id) {
        return actionService.getActionById(id);
    }

    // Crear una nueva acción
    @PostMapping
    public ResponseEntity<Action> createAction(@RequestBody Action action) {
        Action createdAction = actionService.createAction(action);
        return new ResponseEntity<>(createdAction, HttpStatus.CREATED);
    }

    // Actualizar una acción existente
    @PutMapping("/{id}")
    public Action updateAction(@PathVariable Long id, @RequestBody Action updatedAction) {
        return actionService.updateAction(id, updatedAction);
    }

    // Eliminar acción
    @DeleteMapping("/{id}")
    public void deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
    }
}
