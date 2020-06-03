package com.utn.spring.controller;





import com.utn.spring.model.Pet;
import com.utn.spring.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/pet")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService){
        this.petService= petService;
    }

    @PostMapping("/")
    //el @RequestBody transforma el json de nuestra peticion y lo convierte en el objeto persona
    public void addPet(@RequestBody @Valid Pet pet){
        petService.add(pet);
    }

    @GetMapping("/")
    public List<Pet> getAll(@RequestParam (required = false)String name){
        return petService.getAll(name);
    }


}
