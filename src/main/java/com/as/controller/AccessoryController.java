/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.controller;

import com.as.model.Accessory;
import com.as.model.User;
import com.as.service.AccessoryService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author tec_danielc
 */
@RestController
@RequestMapping("/api/accessory")
@CrossOrigin("*")
public class AccessoryController {
    
    @Autowired
    private AccessoryService accesorio;
    
    @GetMapping("/all")
    public List<Accessory> listarAccesorios() {
        return accesorio.listarAccesorios();
    }

    @GetMapping("/{reference}")
    public Optional<Accessory> obtenerUsuario(@PathVariable("reference") String reference) {
        return accesorio.obtenerAccesorio(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory registrar(@RequestBody Accessory accessory) {
        return accesorio.crear(accessory);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory modificar(@RequestBody Accessory accessory) {
        return accesorio.modificar(accessory);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("reference") String reference) {
        accesorio.borrar(reference);
    }
    
}
