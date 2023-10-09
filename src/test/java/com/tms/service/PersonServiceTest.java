package com.tms.service;

import com.tms.domain.Person;
import com.tms.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {


    @InjectMocks
    PersonService personService;

    @Mock
    PersonRepository personRepository;

    static List<Person> personList = null;
    static Person person = null;

    static Long personId = 10L;

    /*
        @BeforeAll
    public static void beforeAll() {
        Authentication authenticationMock = Mockito.mock(Authentication.class);
        SecurityContext securityContextMock = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContextMock.getAuthentication()).thenReturn(authenticationMock);
        SecurityContextHolder.setContext(securityContextMock);
    }
     */

    @BeforeAll
    static void beforeAll() {
        personList = new ArrayList<>();
        person = new Person();
        person.setId(personId);
        person.setFirstName("Anton");
        person.setSecondName("Chekhov");

        personList.add(person);
    }

    @Test
    void getPersonByIdTest() {
        Mockito.when(personRepository.getPersonById(anyLong())).thenReturn(Optional.of(person));

        Optional<Person> result = personService.getPersonById(personId);
        Mockito.verify(personRepository, Mockito.times(1)).getPersonById(anyLong());
        Assertions.assertNotNull(result.get());
    }

    @Test
    void getAllTest() {
        Mockito.when(personRepository.getAll()).thenReturn(personList);

        List<Person> resultList = personService.getAll();
        Mockito.verify(personRepository, Mockito.times(1)).getAll();
        Assertions.assertNotNull(resultList);
    }

    @Test
    void createTest() {
        Mockito.when(personRepository.create(any())).thenReturn(true);

        Boolean result = personService.createPerson(person);
        Mockito.verify(personRepository, Mockito.times(1)).create(any());
        Assertions.assertTrue(result);
    }

    @Test
    void updateTest() {
        Mockito.when(personRepository.update(any())).thenReturn(true);

        Boolean result = personService.updatePerson(person);
        Mockito.verify(personRepository, Mockito.times(1)).update(any());
        Assertions.assertTrue(result);
    }

    @Test
    void deleteTest() {
        personService.deletePersonById(10L);
        Mockito.verify(personRepository, Mockito.times(1)).deleteById(anyLong());
    }
}