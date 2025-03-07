package com.mathewsalv.login_y_registro.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUsuario {
    @NotBlank(message = "Por favor proporciona el nombre de usuario.")
    @Size(min = 3, max = 15, message = "El nombre de usuario debe de contener entre 3 y 15 caracteres.")
    private String usuarioLogin;

    private String contraseñaLogin;

}