/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.repository.crud;

import com.as.model.Accessory;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author tec_danielc
 */
public interface AccessoryCrudRepository extends MongoRepository<Accessory, String>{
    
    public List<Accessory> findByPriceLessThanEqual(double precio);
    
    //@Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Accessory> findByDescriptionLike(String description);
    
}
