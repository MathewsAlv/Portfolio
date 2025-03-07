package com.mathewsalv.admin_tareas.services;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseService {
    
    public abstract Object findAll();

    public abstract Object findById(Long id);

    public abstract Object create(Object object);

    public abstract Object update(Object object);

    public abstract void deleteById(Long id);

}
