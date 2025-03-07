package com.mathewsalv.admin_tareas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathewsalv.admin_tareas.models.Tarea;
import com.mathewsalv.admin_tareas.repositories.TareaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TareaService extends BaseService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Tarea create(Object object) {
        return tareaRepository.save((Tarea) object);
    }

    @Override
    public void deleteById(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea findById(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public Tarea update(Object object) {
        return tareaRepository.save((Tarea) object);
    }
}
