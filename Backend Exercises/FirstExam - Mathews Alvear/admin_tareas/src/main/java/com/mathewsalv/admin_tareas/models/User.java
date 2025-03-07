package com.mathewsalv.admin_tareas.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Base {
    
    @NotNull(message = "Escribe un nombre de usuario")
    @Size(min=3,message = "El nombre debe tener al menos 3 caracteres")
    private String name;

    @NotNull(message = "Escribe tu correo")
    @Email(message = "El email no es valido")
    private String email;


    private String password;

    @NotNull(message = "Escribe una contraseña")
    @Size(min=8,message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message = "La contraseña debe tener al menos una mayuscula, una minuscula y un numero")
    @Transient
    private String passwordForm;

    @Transient
    private String passwordConfirm;


    @ManyToMany
    @JoinTable(
        name = "inscriptions", 
        joinColumns= @JoinColumn(name = "user_id"),   
        inverseJoinColumns = @JoinColumn(name = "tarea_id") 
    )
    private List<Tarea> courses;


}
