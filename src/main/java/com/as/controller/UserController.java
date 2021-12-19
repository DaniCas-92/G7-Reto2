/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.controller;

import com.as.model.User;
import com.as.service.UserService;
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
 * @version 1.0
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    /**
     * Objeto de la clase de servicio user
     */
    @Autowired
    private UserService servicio;

    /**
     * Método que retorna una lista de usuarios
     * @return 
     */
    @GetMapping("/all")
    public List<User> listarUsuarios() {
        return servicio.listar();
    }

    /**
     * Método que retorna el usuario consultado
     * @param iden
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<User> obtenerUsuario(@PathVariable("id") int iden) {
        return servicio.obtenerUsuario(iden);
    }

    /**
     * Método que retorna un valor boolean si existe el email
     * @param email
     * @return 
     */
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return servicio.existeEmail(email);
    }

    /**
     * Método que obtiene un usuario con el email y password correspondiente
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicio.autenticarUsuario(email, password);
    }

    /**
     * Método que crea un usuario en la bd
     * @param user
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return servicio.crear(user);
    }

    /**
     * Método que edita un usuario en la bd
     * @param user
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User modificar(@RequestBody User user) {
        return servicio.modificar(user);
    }

    /**
     * Método que borra un usuario de la bd
     * @param iden 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int iden) {
        servicio.borrar(iden);
    } 
    
    /**
     * Método que consulta el cumpleaños de una persona
     * @param month
     * @return 
     */
    //Reto 5: Cumpleaños del mes
    @GetMapping("/birthday/{month}")
    public List<User> listBirthtDayMonth(@PathVariable("month") String month){
        return servicio.listBirthtDayMonth(month);
    }

}
