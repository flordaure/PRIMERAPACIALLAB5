package com.utn.spring.controller;





import com.utn.spring.model.Person;
import com.utn.spring.projections.PersonCant;
import com.utn.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // expones la ruta y recibir peticiones de afuera. Por eso el Get y el Post.
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired // del llamado al @Autowired que ejecuta al constructor, despues hace una inyeccion de dependencia.
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/")
    public List<Person> getAll(@RequestParam (required = false)String name){
        return personService.getAll(name);
    }

    @GetMapping("/lastN")
    public List<Person> getAlllastname(@RequestParam (required = false)String lastname){
        return personService.getAlllastname(lastname);
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable Integer personId){

        return personService.getPersonById(personId);
    }



    @PostMapping("/")
    //el @RequestBody transforma el json de nuestra peticion y lo convierte en el objeto persona
    public void addPerson(@RequestBody @Valid Person person){
        personService.add(person);
    }

    @GetMapping ("/projection")
    public List<PersonCant>getPersonCant(){
        return personService.getPersonCant();
    }
}
