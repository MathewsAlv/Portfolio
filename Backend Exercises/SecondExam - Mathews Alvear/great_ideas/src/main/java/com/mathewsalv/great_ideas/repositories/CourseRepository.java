package com.mathewsalv.great_ideas.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mathewsalv.great_ideas.models.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

    // Método para buscar todos los cursos
    List<Course> findAll();

    // Método para buscar un curso por id
    Optional<Course> findById(long id);

    // Método para crear un curso
    // Método para actualizar un curso
    Course save(Course course);

    // Método para eliminar un curso
    void deleteById(Long id);

}