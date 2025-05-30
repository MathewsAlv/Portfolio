package com.mathewsalv.great_ideas.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mathewsalv.great_ideas.models.Course;
import com.mathewsalv.great_ideas.models.Inscription;
import com.mathewsalv.great_ideas.models.User;
import com.mathewsalv.great_ideas.repositories.InscriptionRepository;
import com.mathewsalv.great_ideas.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService extends BaseService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Override
    public User create(Object object) {
        return userRepository.save((User) object);
    }
    
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Object object) {
        return userRepository.save((User) object);
    }

    public BindingResult validateUser(User user, BindingResult result) {
        User userExists = userRepository.findByEmail(user.getEmail());
        if (userExists != null) {
            result.rejectValue("email", "errorEmail", "Este email ya está registrado");
        } else if (!user.getPasswordForm().equals(user.getPasswordConfirm())) {
            result.rejectValue("passwordConfirm", "errorConfirm", "Las contraseñas no coinciden");
        } else {
            // Encriptamos la contraseña si todo está bien.
            String hashedPassword = BCrypt.hashpw(user.getPasswordForm(), BCrypt.gensalt());
            user.setPassword(hashedPassword);
        }

        return result;
    }

    public User addCourse(User user, Course course) {
        List<Course> actualCourses = user.getCourses();
        actualCourses.add(course);
        user.setCourses(actualCourses);
        return userRepository.save(user);
    }

    public User removeCourse(User user, Course course) {
        List<Course> actualCourses = user.getCourses();
        // Eliminamos el curso de la lista de cursos del usuario por su id
        actualCourses.removeIf(c -> c.getId() == course.getId());
        user.setCourses(actualCourses);
        return userRepository.save(user);
    }
}
