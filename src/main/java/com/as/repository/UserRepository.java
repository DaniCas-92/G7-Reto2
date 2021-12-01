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
 */

@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository repositorio;
    
    public List<User> getAll() {
        return repositorio.findAll();
    }
    
    public Optional<User> getUser(int id){
        return repositorio.findById(id);
    }
    
    public boolean existEmail(String email){
        Optional<User> usuario = repositorio.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password){
        return repositorio.findByEmailAndPassword(email, password);
    }
    
    public User save(User user){
        return repositorio.save(user);
    }
    
    public User update(User user){
        return repositorio.save(user);
    }
    
    public void delete(User user){
        repositorio.delete(user);
    }
    
}
