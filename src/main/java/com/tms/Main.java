package com.tms;

import com.tms.domain.Person;
import com.tms.repository.PersonRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Person person = new Person();
        person.setFirstName("Anatolyy");
        person.setSecondName("Karpov");
        person.setAge(68);
        person.setIsMarried(true);

        PersonRepository personRepository = new PersonRepository();
        System.out.println(personRepository.create(person));
    }
}
