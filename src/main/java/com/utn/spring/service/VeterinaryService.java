package com.utn.spring.service;


import com.utn.spring.model.Veterinary;
import com.utn.spring.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class VeterinaryService {

    private VeterinaryRepository veterinaryRepository;

    @Autowired
    public VeterinaryService (VeterinaryRepository veterinaryRepository){
        this. veterinaryRepository=veterinaryRepository;
    }

    public void add(final Veterinary veterinary){
        veterinaryRepository.save(veterinary);
    }

    public List<Veterinary> getAll(String name) {
        if (isNull(name)) {
            return veterinaryRepository.findAll();
        }
        return veterinaryRepository.findByName(name);

    }

    public List<Veterinary>withPets(){
        return veterinaryRepository.withPets();
    }
}
