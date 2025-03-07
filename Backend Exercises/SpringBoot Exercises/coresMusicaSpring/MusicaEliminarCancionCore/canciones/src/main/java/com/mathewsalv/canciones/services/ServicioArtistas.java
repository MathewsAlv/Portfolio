package com.mathewsalv.canciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathewsalv.canciones.models.Artista;
import com.mathewsalv.canciones.repositories.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repositorioArtistas;

    public List<Artista> obtenerTodosLosArtistas(){
        return repositorioArtistas.findAll();

    }

    public Artista obtenerArtistaPorId(Long id){
        return repositorioArtistas.findById(id).orElse(null);

    }
    
    public Artista agregarArtista(Artista artistaNew){
        return this.repositorioArtistas.save(artistaNew);
    }
}
