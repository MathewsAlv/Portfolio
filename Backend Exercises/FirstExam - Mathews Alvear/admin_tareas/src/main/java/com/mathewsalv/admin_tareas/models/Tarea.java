package com.mathewsalv.admin_tareas.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "tarea")
public class Tarea extends Base {
    

    @NotBlank(message = "El nombre es requerido")
    @Size(min=3,message = "El nombre debe tener al menos 3 caracteres")
    private String name;

    @NotBlank(message =" El instructor es requerido")
    private String instructor;

    @NotNull(message = "La capacidad es requerida")
    @Min(value = 1, message = "Debe ser minimo 1")
    @Max(value = 3, message = "Debe ser maximo 3")
    private Integer capacity;

    @NotNull(message = "Creador requerido")
    private String creator;



    @ManyToMany
    @JoinTable(
        name = "inscriptions", 
        joinColumns= @JoinColumn(name = "course_id"),   
        inverseJoinColumns = @JoinColumn(name = "user_id")  
    )
    private List<User> users;


}
