package com.utn.spring.controller;


import com.utn.spring.model.Veterinary;
import com.utn.spring.service.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/veterinary")
public class VeterinaryController {

    private final VeterinaryService veterinaryService;

    @Autowired
    public  VeterinaryController (VeterinaryService veterinaryService){
        this.veterinaryService=veterinaryService;
    }

    @PostMapping("/")
    public void addVeterinary (@RequestBody @Valid Veterinary veterinary){
        veterinaryService.add(veterinary);
    }

    @GetMapping("/")
    public List<Veterinary> getAll(@RequestParam (required = false)String name){
        return veterinaryService.getAll(name);
    }

    @GetMapping("/withpet")
    public List<Veterinary>withPets(){
        return veterinaryService.withPets();
    }

}
