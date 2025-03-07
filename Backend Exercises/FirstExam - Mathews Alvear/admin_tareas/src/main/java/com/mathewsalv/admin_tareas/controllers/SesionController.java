package com.mathewsalv.admin_tareas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.mathewsalv.admin_tareas.models.User;
import com.mathewsalv.admin_tareas.models.forms.Session;
import com.mathewsalv.admin_tareas.services.SessionService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@Controller
@RequestMapping("/session")
public class SesionController {
    
    @Autowired
    private SessionService sessionService;

    @PostMapping("")
    public String login(@Valid @ModelAttribute Session session, BindingResult result, HttpSession currentSession,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("user", new User());
            return "home/index.jsp";
        }


        result = sessionService.validateLogin(session.getEmail(), session.getPassword(), currentSession, result);
        if (result.hasErrors()) {
            model.addAttribute("user", new User());
            return "home/index.jsp";
        }

        return "redirect:/courses";
    }

    @PostMapping("/logout")
    public RedirectView logout(HttpSession session) {
        session.invalidate();
        
        return new RedirectView("/");
    }

}
