package com.mathewsalv.admin_tareas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mathewsalv.admin_tareas.models.Tarea;
import com.mathewsalv.admin_tareas.models.User;
import com.mathewsalv.admin_tareas.services.TareaService;
import com.mathewsalv.admin_tareas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/courses")
public class TareasController {
    
    @Autowired
    private final TareaService tareaService;

    @Autowired
    private final UserService userService;


    @GetMapping("")
    public String index(HttpSession session, Model model) {
        model.addAttribute("tareas", tareaService.findAll());

        return "tasks/index.jsp";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tarea", tareaService.findById(id));
        return "tasks/show.jsp";
    }


    @GetMapping("/new")
    public String create(Model model, @ModelAttribute("tarea") Tarea tarea) {
        List<User> listaUser = userService.findAll();
        model.addAttribute("listaUser", listaUser);
        return "tasks/create.jsp";
    }


    @PostMapping("/new")
    public String save(@Valid @ModelAttribute("tarea") Tarea tarea, BindingResult result, HttpSession sesion, Model model) {  
        if (result.hasErrors()) {
            return "tasks/create.jsp";
        }
        tareaService.create(tarea);
        return "redirect:/courses";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Tarea tarea = tareaService.findById(id);
        if (tarea == null) {
            return "redirect:/courses";
        }
    
        List<User> listaUser = userService.findAll();
        model.addAttribute("listaUser", listaUser);
        model.addAttribute("tarea", tarea);
        return "tasks/edit.jsp";
    }


    @PostMapping("/{id}/edit/process")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("tarea") Tarea tarea, BindingResult result, HttpSession sesion, Model model) {
        if (result.hasErrors()) {
            List<User> listaUser = userService.findAll();
            model.addAttribute("listaUser", listaUser);
            return "tasks/edit.jsp";
        }
    
        Tarea existingTarea = tareaService.findById(id);
        if (existingTarea == null) {
            return "redirect:/courses";
        }
        
        User currentUser = (User) sesion.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
    
        existingTarea.setName(tarea.getName());
        existingTarea.setInstructor(tarea.getInstructor());
        existingTarea.setCapacity(tarea.getCapacity());
        existingTarea.setCreator(currentUser.getName());
    
        tareaService.update(existingTarea);
        return "redirect:/courses";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        tareaService.deleteById(id);
        return "redirect:/courses";
    }

}
