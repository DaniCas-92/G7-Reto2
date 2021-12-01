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
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository repositorio;

    public List<User> listar(){
        return repositorio.getAll();
    }

    public Optional<User> obtenerUsuario(int id) {
        return repositorio.getUser(id);
    }

    public boolean existeEmail(String email) {
        return repositorio.existEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repositorio.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    public User crear(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> u = repositorio.getUser(user.getId());
            if(u.isEmpty()){
                if (existeEmail(user.getEmail()) == false) {
                    return repositorio.save(user);
                } else {
                    return user;
                }
            } else{
                return user;
            }
        }
    }
    
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
    
    public boolean borrar(int id){
        Optional<User> user = repositorio.getUser(id); 
        
        if (user.isEmpty()){ 
            return false; 
        } else { 
            repositorio.delete(user.get()); 
            return true; 
        }
    }
    
}
