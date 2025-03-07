package com.mathewsalv.admin_tareas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mathewsalv.admin_tareas.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
    

    @Override
    List<User> findAll();


    <Optinal>User findById(long id);


    <Optional>User findByEmail(String email);

    @Override
    User save(User user);

    
    @Override
    void deleteById(Long id);

}
