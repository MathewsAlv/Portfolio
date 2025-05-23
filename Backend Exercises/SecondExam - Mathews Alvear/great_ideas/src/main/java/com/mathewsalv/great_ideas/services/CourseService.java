package com.mathewsalv.great_ideas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathewsalv.great_ideas.models.Course;
import com.mathewsalv.great_ideas.repositories.CourseRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseService extends BaseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course create(Object object) {
        return courseRepository.save((Course) object);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public List<Course> findAll(String sort) {
        List<Course> cursos = courseRepository.findAll();

        // Ordenar cursos por cantidad de usuarios

        cursos.sort((a, b) -> {
            if (sort.toUpperCase().equals("ASC")) {
                return a.getUsers().size() > b.getUsers().size() ? 1 : -1;
            } else {
                return a.getUsers().size() > b.getUsers().size() ? -1 : 1;
            }
        });

        /*
         * cursos.sort((a, b) -> {
         * if (sort.toUpperCase().equals("ASC")) {
         * if (a.getInstructor().toUpperCase().equals("VALERIA") &&
         * (b.getInstructor().toUpperCase().equals("NESTOR") ||
         * b.getInstructor().toUpperCase().equals("CAROLINA"))) {
         * return 1;
         * } else if (a.getInstructor().toUpperCase().equals("NESTOR")
         * && b.getInstructor().toUpperCase().equals("CAROLINA")) {
         * return 1;
         * }
         * return -1;
         * }
         * if (a.getInstructor().toUpperCase().equals("CAROLINA") &&
         * (b.getInstructor().toUpperCase().equals("NESTOR") ||
         * b.getInstructor().toUpperCase().equals("VALERIA"))) {
         * return 1;
         * } else if (a.getInstructor().toUpperCase().equals("NESTOR")
         * && b.getInstructor().toUpperCase().equals("VALERIA")) {
         * return 1;
         * }
         * return -1;
         * });
         */

        return cursos;
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course findById(Long id, String sort) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.getInscriptions().sort((a, b) -> {
                if (sort.toUpperCase().equals("ASC")) {
                    return a.getCreatedAt().after(b.getCreatedAt()) ? 1 : -1;
                }
                return a.getCreatedAt().after(b.getCreatedAt()) ? -1 : 1;
            });
        }

        return course;
    }

    @Override
    public Course update(Object object) {
        return courseRepository.save((Course) object);
    }

}
