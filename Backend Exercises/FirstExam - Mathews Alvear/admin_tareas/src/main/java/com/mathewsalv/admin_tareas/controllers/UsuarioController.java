package com.mathewsalv.admin_tareas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mathewsalv.admin_tareas.models.User;
import com.mathewsalv.admin_tareas.models.forms.Session;
import com.mathewsalv.admin_tareas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/users")
public class UsuarioController {
    
    @Autowired
    private UserService userService;

    
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "home/index.jsp";
    }

    
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "users/show.jsp";
    }

    
    @GetMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        return "users/create.jsp";
    }

    
    @PostMapping("/new")
    public String save(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession currentSession) {
        result = userService.validateUser(user, result, currentSession);
        if (result.hasErrors()) {
            model.addAttribute("session", new Session());
            return "home/index.jsp";
        }
        userService.create(user);
        return "tasks/index.jsp";
    }

    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "users/edit.jsp";
    }

    
    @PutMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/edit.jsp";
        }
        return "redirect:/users";
    }

    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

}
