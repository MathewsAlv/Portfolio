package com.mathewsalv.admin_tareas.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mathewsalv.admin_tareas.models.User;
import com.mathewsalv.admin_tareas.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService extends BaseService{
    
    @Autowired
    private UserRepository userRepository;

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

    public BindingResult validateUser(User user, BindingResult result, HttpSession session) {
        User userExists = userRepository.findByEmail(user.getEmail());
        if (userExists != null) {
            result.rejectValue("email", "errorEmail", "Este email ya está registrado");
        } else if (!user.getPasswordForm().equals(user.getPasswordConfirm())) {
            result.rejectValue("passwordConfirm", "errorConfirm", "Las contraseñas no coinciden");
        } else {
            
            String hashedPassword= BCrypt.hashpw(user.getPasswordForm(), BCrypt.gensalt());
            user.setPassword(hashedPassword);  
            session.setAttribute("currentUser", user);        
        }

        return result;
    }
}
