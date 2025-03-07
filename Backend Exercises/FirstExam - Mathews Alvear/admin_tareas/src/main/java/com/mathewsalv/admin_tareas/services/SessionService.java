package com.mathewsalv.admin_tareas.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mathewsalv.admin_tareas.models.User;
import com.mathewsalv.admin_tareas.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;


@Service
public class SessionService {

    @Autowired
    private UserRepository userRepository;


    public BindingResult validateLogin(String email, String password, HttpSession session, BindingResult result) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            result.rejectValue("email", "error", "Email no registrado");
        } else if (!BCrypt.checkpw(password, user.getPassword())) {
            result.rejectValue("password", "error", "Contraseña incorrecta");
        }else{
            session.setAttribute("currentUser", user);
        }

        return result;
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }
}
