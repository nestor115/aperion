package com.aperion.aperion.service;
import com.aperion.aperion.model.Action;
import com.aperion.aperion.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    // Obtener todas las acciones
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }
    // Obtener una acción por ID
    public Action getActionById(Long id) {
        return actionRepository.findById(id).orElseThrow(() -> new RuntimeException("Action not found"));
    }

    // Crear una nueva acción
    public Action createAction(Action action) {
        return actionRepository.save(action);
    }

    // Actualizar una acción
    public Action updateAction(Long id, Action updatedAction) {
        Action existingAction = actionRepository.findById(id).orElseThrow(() -> new RuntimeException("Action not found"));
        existingAction.setName(updatedAction.getName());
        existingAction.setActionPoints(updatedAction.getActionPoints());
        return actionRepository.save(existingAction);
    }

    // Eliminar acción
    public void deleteAction(Long id) {
        Action action = actionRepository.findById(id).orElseThrow(() -> new RuntimeException("Action not found"));
        actionRepository.delete(action);
    }
}
