package com.as;

import com.as.model.Accessory;
import com.as.model.User;
import com.as.repository.crud.AccessoryCrudRepository;
import com.as.repository.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {
    
    @Autowired
    private UserCrudRepository userRepo;
    
    @Autowired
    private AccessoryCrudRepository accessoryCrud;

    public static void main(String[] args) {
        SpringApplication.run(RetodosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("Aqui se ejecutaran la creación de documentos mongo...");
        
        userRepo.deleteAll();
        accessoryCrud.deleteAll();

//        userRepo.saveAll(List.of(
//            new User(1, "52369563", "DANIEL CASTRILLON", "CR 19 A 63 C 37", "3256323212", "daniel1@gmail.edu.com", "daniel123.", "ZONA 1", "ADM"),
//            new User(2, "52369563", "MARCELA RUIZ", "CR 19 A 63 C 37", "3256323212", "marcela2@gmail.edu.com", "marcela123.", "ZONA 1", "COORD"),
//            new User(3, "52369563", "GLORIA CASTRILLON", "CR 19 A 63 C 37", "3256323212", "gloria3@gmail.edu.com", "gloria123.", "ZONA 1", "ASE")
//        ));
        
//        accessoryCrud.saveAll(List.of(
//                new Accessory("AP-903", "ACME", "MATERIAL 1", "PRESENTACION 1", "DESCRIPCION DETALLADA 1", true, 0, 0, ""),
//                new Accessory("AP-901", "ACME", "MATERIAL 2", "PRESENTACION 2", "DESCRIPCION DETALLADA 2", true, 0, 0, "")
//        ));
//        
//        System.out.println("Listado de usuarios");
//        userRepo.findAll().forEach(System.out::println);
//        
//        System.out.println("Listado de accesorios");
//        accessoryCrud.findAll().forEach(System.out::println);
//        
//        Optional<User> usuario = userRepo.findByEmail("daniel1@gmail.edu.com");
//        
//        if(usuario.isPresent()){
//            System.out.println("Datos del usuario: " + usuario.get());
//        }
//        
//        Optional<User> usuario2 = userRepo.findByEmailAndPassword("daniel1@gmail.edu.com","daniel123.");
//        
//        if(usuario2.isPresent()){
//            System.out.println("Datos del usuario: " + usuario2.get());
//        }
    }

}
