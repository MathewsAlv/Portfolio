package com.mathewsalv.login_y_registro.services;


import com.mathewsalv.login_y_registro.model.LoginUsuario;
import com.mathewsalv.login_y_registro.model.Usuario;
import com.mathewsalv.login_y_registro.repositories.RepositorioUsuario;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class ServicioUsuario {
    @Autowired
    private final RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Usuario agregarUsuario(Usuario usuario) {
        String contraseñaEncriptada = BCrypt.hashpw(usuario.getContraseña(), BCrypt.gensalt());
        usuario.setContraseña(contraseñaEncriptada);
        return this.repositorioUsuario.save(usuario);
    }

    public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
        if (!usuario.getContraseña().equals(usuario.getConfirmacionContraseña())) {
            validaciones.rejectValue("confirmacionContraseña", "contraseñaNoCoincide",
                    "Las contraseñas deben de ser iguales.");
        }

        if (repositorioUsuario.existsByNombreUsuario(usuario.getNombreUsuario())) {
            validaciones.rejectValue("nombreUsuario", "usuarioDuplicado",
                    "El nombre de usuario ya existe. Por favor, elige otro.");
            System.out.println("duplicado");
        }

        return validaciones;
    }

    public BindingResult validarLogin(BindingResult resultado, LoginUsuario loginUsuario) {
        Usuario usuarioExistente = this.repositorioUsuario.getByNombreUsuario(loginUsuario.getUsuarioLogin());
        if (usuarioExistente == null) {
            resultado.rejectValue("usuarioLogin", "Missing", "Credenciales incorrectas!");
        } else {
            if (!BCrypt.checkpw(loginUsuario.getContraseñaLogin(), usuarioExistente.getContraseña())) {
                resultado.rejectValue("usuarioLogin", "Matches", "Credenciales incorrectas!");
            }
        }

        return resultado;
    }

}