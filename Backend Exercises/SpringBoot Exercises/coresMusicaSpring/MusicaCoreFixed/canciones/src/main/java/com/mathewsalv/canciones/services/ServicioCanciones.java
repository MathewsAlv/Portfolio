package com.mathewsalv.canciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathewsalv.canciones.models.Cancion;
import com.mathewsalv.canciones.repositories.RepositorioCanciones;


@Service
public class ServicioCanciones {

    @Autowired
    private RepositorioCanciones repositorioCanciones;
    

    public List<Cancion> obtenerTodasLasCanciones(){
        return repositorioCanciones.findAll();

    }

    public Cancion obtenerCancionPorId(Long id){
        return repositorioCanciones.findById(id).orElse(null);

    }

}
