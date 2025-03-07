package com.mathewsalv.canciones.models;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=3, max=20, message="Proporciona el Nombre del Artista.")
    @NotNull
    private String nombre;

    @Size(min=3, max=20, message="Proporciona el Apellido del Artista")
    @NotNull
    private String apellido;

    @Size(min=3, max=256, message="Proporciona una Biografia para el Artista.")
    @NotNull
    private String biografia;

    @OneToMany(mappedBy= "artista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cancion> canciones;


    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

}
