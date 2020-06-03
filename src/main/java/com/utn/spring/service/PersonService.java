package com.utn.spring.service;




import com.utn.spring.model.Person;
import com.utn.spring.projections.PersonCant;
import com.utn.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService (PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void add(final Person person){
        personRepository.save(person);
    }



    public Person getPersonById(Integer personId) {
        return personRepository.findById(personId).get();
        /*
                .orElseThrow(new HTTPException(HttpStatus.NOT_FOUND.value()))*/

    }

    public List<Person> getAll(String name) {
        if (isNull(name)) {
            return personRepository.findAll();
        }
       return personRepository.findByName(name);

    }

    public List<Person> getAlllastname(String lastname) {
        if (isNull(lastname)) {
            return personRepository.findAll();
        }
        return personRepository.findBylastname(lastname);

    }

    public List<PersonCant>getPersonCant(){
        return personRepository.getPersonCant();
    }
}
