/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.service;

import com.as.model.Accessory;
import com.as.repository.AccessoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tec_danielc
 */
@Service
public class AccessoryService {

    @Autowired
    private AccessoryRepository repositorio;

    public List<Accessory> listarAccesorios() {
        return repositorio.getAll();
    }

    public Optional<Accessory> obtenerAccesorio(String reference) {
        return repositorio.getAccessory(reference);
    }

    public Accessory crear(Accessory accessory) {
        if (accessory.getReference() == null) {
            return accessory;
        } else {
            return repositorio.save(accessory);
        }
    }
    
    public Accessory modificar(Accessory accessory){
        if (accessory.getReference() != null) {
            Optional<Accessory> a = repositorio.getAccessory(accessory.getReference());
            if (!a.isEmpty()) {
                if (accessory.getReference()!= null) {
                    a.get().setReference(accessory.getReference());
                }
                if (accessory.getBrand()!= null) {
                    a.get().setBrand(accessory.getBrand());
                }
                if (accessory.getCategory()!= null) {
                    a.get().setCategory(accessory.getCategory());
                }
                if (accessory.getMaterial()!= null) {
                    a.get().setMaterial(accessory.getMaterial());
                }
                if (accessory.getDescription()!= null) {
                    a.get().setDescription(accessory.getDescription());
                }
                
                a.get().setAvailability(accessory.isAvailability());
                
                if (accessory.getPrice()!= 0.0) {
                    a.get().setPrice(accessory.getPrice());
                }
                if (accessory.getQuantity()!= 0.0) {
                    a.get().setQuantity(accessory.getQuantity());
                }
                if (accessory.getPhotography()!= null) {
                    a.get().setPhotography(accessory.getPhotography());
                }

                repositorio.update(a.get());
                return a.get();
            } else {
                return accessory;
            }
        } else {
            return accessory;
        }
    }
    
    public boolean borrar(String reference){
        Boolean aBoolean = obtenerAccesorio(reference).map(accesory -> {
            repositorio.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Accessory> productsByPrice(double precio){
        return repositorio.productsByPrice(precio);
    }
    
    public List<Accessory> findByDescriptionLike(String description){
        return repositorio.findByDescriptionLike(description);
    }
}
