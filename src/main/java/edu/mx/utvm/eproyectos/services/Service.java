/*
 * Service generico
 * 
 * @author Mario Rivera
 */
package edu.mx.utvm.eproyectos.services;

import java.io.Serializable;
import java.util.List;

public interface Service<T, PK extends Serializable> {
    void create(T newInstance);
    T read(PK id);
    void update(T transientObject);
    void delete(T persistentObject);
    List<T> findAll();
}