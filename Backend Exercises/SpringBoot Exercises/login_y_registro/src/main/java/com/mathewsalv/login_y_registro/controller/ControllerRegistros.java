package com.mathewsalv.login_y_registro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.mathewsalv.login_y_registro.model.LoginUsuario;
import com.mathewsalv.login_y_registro.model.Usuario;
import com.mathewsalv.login_y_registro.services.ServicioUsuario;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControllerRegistros {

    @Autowired
    private final ServicioUsuario servicioUsuario;

    public ControllerRegistros(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/")
    public String index(Model modelo, Usuario usuario, LoginUsuario loginUsuario) {
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("loginUsuario", loginUsuario);
        return "index.jsp";
    }

    @GetMapping("/inicio")
    public String inicio(HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }
        return "inicio.jsp";
    }

    @PostMapping("/procesa/registro")
    public String procesaRegistro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult validaciones,
            HttpSession session, Model modelo) {

        validaciones = this.servicioUsuario.validarRegistro(validaciones, usuario);
        if (validaciones.hasErrors()) {
            System.out.println(validaciones.getFieldErrors());
            modelo.addAttribute("loginUsuario", new LoginUsuario());
            return "index.jsp";
        }

        this.servicioUsuario.agregarUsuario(usuario);
        session.setAttribute(usuario.getNombreUsuario(), usuario);

        return "inicio.jsp";
    }

    @PostMapping("/procesa/login")
    public String procesaLogin(HttpSession session, @Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
            BindingResult validaciones, Model modelo) {

        System.out.println("did reach procesa login");
        validaciones = this.servicioUsuario.validarLogin(validaciones, loginUsuario);
        if (validaciones.hasErrors()) {
            System.out.println(validaciones.getFieldErrors());
            modelo.addAttribute("usuario", new Usuario());

            return "index.jsp";
        }
        return "inicio.jsp";
    }

    @PostMapping("/procesa/logout")
    public String logout(HttpSession sesion) {
        sesion.invalidate();

        return "redirect:/";
    }

}
