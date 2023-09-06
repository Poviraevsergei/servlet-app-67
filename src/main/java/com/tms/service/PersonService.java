package com.tms.service;

import com.tms.domain.Person;
import com.tms.repository.PersonRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.List;

public class PersonService {

    private final PersonRepository personRepository = new PersonRepository();

    public List<Person> getAll(HttpServletRequest request) {
        List<Person> resultList = personRepository.getAll();
        request.setAttribute("result", resultList);
        return resultList;
    }

    public Person getById(HttpServletRequest request) {
        //logic to find one person
        return new Person();
    }

    public Boolean createUser(HttpServletRequest request) {
        Person person = new Person();
        person.setFirstName(request.getParameter("first-name"));
        person.setSecondName(request.getParameter("second-name"));
        person.setAge(Integer.parseInt(request.getParameter("age")));
        person.setIsMarried(Boolean.parseBoolean(request.getParameter("is-married")));
        Boolean isCreated = personRepository.create(person);
        request.setAttribute("result", isCreated);
        return isCreated;
    }

    public Boolean updateUser(HttpServletRequest request) {
        return false;
    }

    public Boolean deleteUser(HttpServletRequest request) {
        return false;
    }
}
