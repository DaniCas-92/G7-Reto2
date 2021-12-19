/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.service;

import com.as.model.User;
import com.as.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tec_danielc
 * @version 1.0
 */
@Service
public class UserService {
    
    /**
     * Objeto de la clase User Repository
     */
    @Autowired
    private UserRepository repositorio;

    /**
     * Método que devuelve una lista de usuarios
     * @return 
     */
    public List<User> listar(){
        return repositorio.getAll();
    }

    /**
     * Método que retorna un usuario opcional
     * @param id
     * @return 
     */
    public Optional<User> obtenerUsuario(int id) {
        return repositorio.getUser(id);
    }

    /**
     * Método que devuelve true en caso de existir email
     * de lo contrario devuelve false
     * @param email
     * @return 
     */
    public boolean existeEmail(String email) {
        return repositorio.existEmail(email);
    }

    /**
     * Método que devuelve un usuario null o con datos en caso de existir
     * en bd
     * @param email
     * @param password
     * @return 
     */
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repositorio.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    /**
     * Método que crea un usuario en la bd
     * @param user
     * @return 
     */
    public User crear(User user) {
        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = repositorio.lastUserId();
        
        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty())
                user.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        
        Optional<User> e = repositorio.getUser(user.getId());
        if (e.isEmpty()) {
            if (existeEmail(user.getEmail())==false){
                return repositorio.save(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    /**
     * Método que modifica un usuario ya existente en la BD
     * @param user
     * @return 
     */
    public User modificar(User user){
        if (user.getId() != null) {
            Optional<User> u = repositorio.getUser(user.getId());
            if (!u.isEmpty()) {
                if (user.getIdentification()!= null) {
                    u.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    u.get().setName(user.getName());
                }
                if (user.getBirthtDay()!= null) {
                    u.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay()!= null) {
                    u.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress()!= null) {
                    u.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone()!= null) {
                    u.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail()!= null) {
                    u.get().setEmail(user.getEmail());
                }
                if (user.getPassword()!= null) {
                    u.get().setPassword(user.getPassword());
                }
                if (user.getZone()!= null) {
                    u.get().setZone(user.getZone());
                }
                if (user.getType()!= null) {
                    u.get().setType(user.getType());
                }

                repositorio.save(u.get());
                return u.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    /**
     * Método que elimina un usuario de la bd
     * @param id
     * @return 
     */
    public boolean borrar(int id){
        Optional<User> user = repositorio.getUser(id); 
        
        if (user.isEmpty()){ 
            return false; 
        } else { 
            repositorio.delete(user.get()); 
            return true; 
        }
    }
    
    /**
     * Método que muestra un listado de usuarios según el mes digitado
     * @param month
     * @return 
     */
    public List<User> listBirthtDayMonth(String month){
        return repositorio.listBirthtDayMonth(month);
    }
    
}
