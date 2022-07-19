package com.springboot.ejemplo.apirestejemplo.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.ejemplo.apirestejemplo.entidades.Fiesta;
import com.springboot.ejemplo.apirestejemplo.repositorios.FiestaRepository;

@Controller
@RequestMapping("/api/fiestas")
public class FiestaController {

    @Autowired
    private FiestaRepository fiestaRepository;

    //Metodo para Obtener listado de fiestas
    @GetMapping
    public ResponseEntity<Collection<Fiesta>> listarFiestas() {

        return new ResponseEntity<>(fiestaRepository.findAll(), HttpStatus.OK);
    }


    //Metodo para obtener fiesta por id
    @GetMapping("/{id}")
    public ResponseEntity<Fiesta> obtenerFiestaPorId(@PathVariable Long id) {
        Fiesta fiesta = fiestaRepository.findById(id).orElseThrow();
        if (fiesta != null) {
            return new ResponseEntity<>(fiestaRepository.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //Guardar evento fiesta
    @PostMapping
    public ResponseEntity<?> guardarFiesta(@RequestBody Fiesta fiesta) {
        return new ResponseEntity<>(fiestaRepository.save(fiesta), HttpStatus.CREATED);
    }


    //Metodo para eliminar un evento fiesta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFiesta(@PathVariable Long id) {
        fiestaRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
}
