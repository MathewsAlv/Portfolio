package com.mathewsalv.great_ideas.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
    
    @NotNull(message = "El nombre es requerido")
    @Size(min=3,message = "El nombre debe tener al menos 3 caracteres")
    private String name;

    @NotNull(message = "El email es requerido")
    @Email(message = "El email no es valido")
    private String email;


    private String password;

    @NotNull(message = "La contraseña es requerida")
    @Size(min=8,message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message = "La contraseña debe tener al menos una mayuscula, una minuscula y un numero")
    @Transient
    private String passwordForm;

    @Transient
    private String passwordConfirm;


    /* RELACIONES */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "inscriptions", //nombre de la tabla intermedia
        joinColumns= @JoinColumn(name = "user_id"),   //nombre de la columna de la tabla intermedia que hace referencia a la tabla actual
        inverseJoinColumns = @JoinColumn(name = "course_id")  //nombre de la columna de la tabla intermedia que hace referencia a la tabla con la que se relaciona
    )
    private List<Course> courses;


    @OneToMany(mappedBy = "user")
    private List<Inscription> inscriptions;




    //Método para buscar una inscripcion por id del curso
    public Inscription findInscriptionByCourseId(Long id){
        for(Inscription inscription: this.inscriptions){
            if(inscription.getCourse().getId() == id){
                return inscription;
            }
        }
        return null;
    }


}