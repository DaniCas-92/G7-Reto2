/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.repository.crud;

import com.as.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author tec_danielc
 */
public interface UserCrudRepository extends MongoRepository<User, Integer>{
    
    public Optional<User> findByEmailAndPassword(String email, String password);
    public Optional<User> findByEmail(String email);
    //Para seleccionar el usuario con el id maximo
    //db.users.find().limit(1).sort({$natural:-1}) en mongo db
    Optional<User> findTopByOrderByIdDesc();   
    
    //Reto 5: 
    List<User> findByMonthBirthtDay(String month);
    
}
