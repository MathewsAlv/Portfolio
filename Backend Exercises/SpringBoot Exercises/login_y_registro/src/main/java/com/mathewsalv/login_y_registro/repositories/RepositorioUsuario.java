package com.mathewsalv.login_y_registro.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mathewsalv.login_y_registro.model.Usuario;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
    public Usuario getByNombreUsuario(String nombreUsuario);

    public boolean existsByNombreUsuario(String nombreUsuario);
}
