package com.mathewsalv.great_ideas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mathewsalv.great_ideas.models.User;
import com.mathewsalv.great_ideas.models.forms.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("session", new Session());
        return "home/index.jsp";
    }

}