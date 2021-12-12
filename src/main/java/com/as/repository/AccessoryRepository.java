/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.repository;

import com.as.model.Accessory;
import com.as.repository.crud.AccessoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tec_danielc
 */
@Repository
public class AccessoryRepository {
    
    @Autowired
    private AccessoryCrudRepository repositorio;
    
    public List<Accessory> getAll() {
        return repositorio.findAll();
    }
    
    public Optional<Accessory> getAccessory(String reference){
        return repositorio.findById(reference);
    }
    
    public Accessory save(Accessory accessory){
        return repositorio.save(accessory);
    }
    
    public void update(Accessory accessory){
        repositorio.save(accessory);
    }
    
    public void delete(Accessory accessory){
        repositorio.delete(accessory);
    }
    
    public List<Accessory> productsByPrice(double precio){
        return repositorio.findByPriceLessThanEqual(precio);
    }
    
    public List<Accessory> findByDescriptionLike(String description){
        return repositorio.findByDescriptionLike(description);
    }
    
}
