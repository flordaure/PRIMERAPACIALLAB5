package com.utn.spring.repository;


import com.utn.spring.model.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinaryRepository extends JpaRepository <Veterinary, Integer> {


    List<Veterinary> findByName(String name);

    @Query (value = "select * from veterinary v inner join pet p where p.id=v.id" , nativeQuery = true)
    List<Veterinary>withPets();


}
