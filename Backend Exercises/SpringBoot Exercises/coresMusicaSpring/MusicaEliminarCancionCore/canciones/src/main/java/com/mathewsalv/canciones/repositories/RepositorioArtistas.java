package com.mathewsalv.canciones.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mathewsalv.canciones.models.Artista;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long>{
    
    @Override
    List<Artista> findAll();
}
