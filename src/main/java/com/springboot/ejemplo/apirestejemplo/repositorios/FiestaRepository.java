package com.springboot.ejemplo.apirestejemplo.repositorios;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ejemplo.apirestejemplo.entidades.Fiesta;

@Repository
public interface FiestaRepository extends CrudRepository<Fiesta, Long> {

    Collection<Fiesta> findAll();
}
