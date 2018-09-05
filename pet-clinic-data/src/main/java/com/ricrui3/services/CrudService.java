package com.ricrui3.services;

import java.util.Set;

/**
 * Created By ricardo.ruiz
 */
public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
