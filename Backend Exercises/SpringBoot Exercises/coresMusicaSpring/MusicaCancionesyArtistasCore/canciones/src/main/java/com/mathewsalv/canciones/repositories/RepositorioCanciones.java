package com.mathewsalv.canciones.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mathewsalv.canciones.models.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
    
    @Override
    List<Cancion> findAll();
}
