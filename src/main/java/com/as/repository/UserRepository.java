/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.repository;

import com.as.model.User;
import com.as.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tec_danielc
 * @version 1.0
 */

@Repository
public class UserRepository {
    
    /**
     * Objeto de la clase user repository
     */
    @Autowired
    private UserCrudRepository repositorio;
    
    /**
     * Método que retorna todo los usuarios 
     * @return 
     */
    public List<User> getAll() {
        return repositorio.findAll();
    }
    
    /**
     * Método que retorna 1 usuario
     * @param id
     * @return 
     */
    public Optional<User> getUser(int iden){
        return repositorio.findById(iden);
    }
    
    /**
     * Método que valida si existe email en bd
     * @param email
     * @return 
     */
    public boolean existEmail(String email){
        Optional<User> usuario = repositorio.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    /**
     * Método que valida que el usuario y contraseña sean corectos
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> authenticateUser(String email, String password){
        return repositorio.findByEmailAndPassword(email, password);
    }
    
    /**
     * Método para almacenar un usuario en bd
     * @param user
     * @return 
     */
    public User save(User user){
        return repositorio.save(user);
    }
    
    /**
     * Métod para modificar un usuario existente en bd
     * @param user
     * @return 
     */
    public User update(User user){
        return repositorio.save(user);
    }
    
    /**
     * Método para borrar un usuario
     * @param user 
     */
    public void delete(User user){
        repositorio.delete(user);
    }
    
    /**
     * Método para obtener el último id de usuario
     * @return 
     */
    public Optional<User> lastUserId(){
        return repositorio.findTopByOrderByIdDesc();
    }
     
    /**
     * Método para mostrar los usuarios que cumplen en el mes digitado
     * @param month
     * @return 
     */
    public List<User> listBirthtDayMonth(String month){
        return repositorio.findByMonthBirthtDay(month);
    }
    
}
