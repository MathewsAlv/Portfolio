package com.mathewsalv.great_ideas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mathewsalv.great_ideas.models.Inscription;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription, Long> {


    //Método para crear una inscripción
    //Método para actualizar una inscripción
    Inscription save(Inscription inscription);

    
    //Método para eliminar una inscripción
    void deleteById(Long id);

    //Método para eliminar una inscripcion por curso y usuario
    void deleteByCourseIdAndUserId(Long courseId, Long userId);

    //Método para buscar una inscripcion por curso y usuario
    Inscription findByCourseIdAndUserId(Long courseId, Long userId);


}