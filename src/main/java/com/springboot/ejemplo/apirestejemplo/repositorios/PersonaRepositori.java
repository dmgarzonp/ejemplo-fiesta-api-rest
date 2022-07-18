package com.springboot.ejemplo.apirestejemplo.repositorios;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ejemplo.apirestejemplo.entidades.Persona;

@Repository
public interface PersonaRepositori extends CrudRepository<Persona, Long> {

    Collection<Persona> findAll();
}
