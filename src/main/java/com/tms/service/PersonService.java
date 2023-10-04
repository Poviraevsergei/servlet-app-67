package com.tms.service;

import com.tms.domain.Person;
import com.tms.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.getAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.getPersonById(id);
    }

    public Boolean createPerson(Person person) {
        return personRepository.create(person);
    }

    public Boolean updatePerson(Person person) {
        return personRepository.update(person);
    }

    public void deletePersonById(Long id){
        personRepository.deleteById(id);
    }
}
