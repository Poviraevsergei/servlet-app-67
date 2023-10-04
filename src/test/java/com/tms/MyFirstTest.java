package com.tms;

import com.tms.controller.FileController;
import com.tms.domain.Person;
import com.tms.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyFirstTest {

    static Person person = null;

    @Autowired
    FileController fileController;

    @BeforeAll
    static void beforeAll() {
        person = new Person();
        System.out.println("Will do it before All methods!");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each method!");
    }

    @Test
    public void myFirstTest() {
        //Проверка наличия бина
        Assertions.assertNotNull(fileController);
    }

    @Test
    public void mySecondTest() {
        System.out.println("This is my second test!!");
    }
}
