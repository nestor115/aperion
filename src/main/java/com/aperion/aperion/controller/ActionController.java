package com.aperion.aperion.controller;

import com.aperion.aperion.model.Action;
import com.aperion.aperion.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Action createAction(@RequestBody Action action) {
        return actionService.createAction(action);
    }

    // Actualizar una acción existente
    @PutMapping("/{id}")
    public Action updateAction(@PathVariable Long id, @RequestBody Action action) {
        return actionService.updateAction(id, action);
    }

    // Eliminar acción
    @DeleteMapping("/{id}")
    public void deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
    }
}
