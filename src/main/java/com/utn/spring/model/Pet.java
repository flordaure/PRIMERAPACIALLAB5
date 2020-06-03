package com.utn.spring.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer kg;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    //le dice a hibernate que el objeto persona que está dentro de mascota es una referencia para las entidades
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Veterinary veterinary;


}
