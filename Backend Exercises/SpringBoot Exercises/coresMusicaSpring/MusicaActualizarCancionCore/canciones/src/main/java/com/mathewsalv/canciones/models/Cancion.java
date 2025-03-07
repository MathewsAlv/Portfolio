package com.mathewsalv.canciones.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=5, max=20, message="Proporciona un titulo/nombre de la cancion.")
    @NotNull
    private String titulo;

    @Size(min=3, max=20, message="Proporciona el nombre de la Banda/Artista")
    @NotNull
    private String artista;

    @Size(min=3, max=20, message="Proporciona el nombre del Album.")
    @NotNull
    private String album;

    @Size(min=3, max=20, message="Proporciona el/los Genero/s de la cancion.")
    @NotNull
    private String genero;

    @Size(min=3, max=20, message="Proporciona el idioma de la cancion")
    @NotNull
    private String idioma;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

}