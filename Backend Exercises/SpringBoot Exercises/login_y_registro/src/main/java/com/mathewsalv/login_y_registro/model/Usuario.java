package com.mathewsalv.login_y_registro.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios", uniqueConstraints = { @UniqueConstraint(columnNames = "nombre_usuario") })
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario", nullable = false, length = 15)
    @Size(min = 3, max = 15, message = "El nombre de usuario debe tener entre 3 y 15 caracteres.")
    @NotNull(message = "El nombre de usuario no puede ser nulo.")
    private String nombreUsuario;

    @Column(nullable = false)
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$", message = "La contraseña debe incluir al menos una mayúscula, una minúscula y un número.")
    private String contraseña;

    @Transient
    @NotNull(message = "La confirmación de la contraseña no puede ser nula.")
    @Size(min = 8, message = "La confirmación de la contraseña debe tener al menos 8 caracteres.")
    private String confirmacionContraseña;

    @Column(nullable = false)
    @Email(message = "Debe proporcionar un correo electrónico válido.")
    private String correo;

    @Column(nullable = false)
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres.")
    @Pattern(regexp = "^[^\\d]*$", message = "El nombre no puede contener números.")
    private String nombre;

    @Column(nullable = false)
    @Size(min = 3, message = "El apellido debe tener al menos 3 caracteres.")
    @Pattern(regexp = "^[^\\d]*$", message = "El apellido no puede contener números.")
    private String apellido;

    @Column(name = "fecha_de_nacimiento", nullable = false)
    @Past(message = "La fecha de nacimiento debe ser una fecha en el pasado.")
    private LocalDate fechaDeNacimiento;

    @Column(name = "fecha_creacion", nullable = false, updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime fechaActualizacion;

}
