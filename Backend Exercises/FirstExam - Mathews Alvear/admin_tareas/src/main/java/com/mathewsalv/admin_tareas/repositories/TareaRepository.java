package com.mathewsalv.admin_tareas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mathewsalv.admin_tareas.models.Tarea;

public interface TareaRepository extends CrudRepository<Tarea, Long> {
    
    List<Tarea> findAll();


    Optional<Tarea> findById(long id);


    Tarea save(Tarea tarea);


    void deleteById(Long id);

}
