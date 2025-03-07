package com.mathewsalv.admin_tareas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mathewsalv.admin_tareas.models.User;
import com.mathewsalv.admin_tareas.models.forms.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("session", new Session());
        return "home/index.jsp";
    }

}
