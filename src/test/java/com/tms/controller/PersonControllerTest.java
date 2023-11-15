package com.tms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.domain.Person;
import com.tms.security.filter.JwtAuthenticationFilter;
import com.tms.service.PersonService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PersonController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PersonControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    JwtAuthenticationFilter jaf;

    @MockBean
    PersonService personService;

    static List<Person> personList = null;
    static Person person = null;

    @BeforeAll
    static void beforeAll() {
        personList = new ArrayList<>();
        person = new Person();
        person.setId(10L);
        person.setFirstName("Anton");
        person.setSecondName("Chekhov");

        personList.add(person);
    }

    @Test
    void getAllTest() throws Exception {
        //1. настойка
        Mockito.when(personService.getAll()).thenReturn(personList);

        //2. запуск и сравнение
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].id", Matchers.equalTo(10)));
    }

    @Test
    void createTest() throws Exception {
        Mockito.when(personService.createPerson(any())).thenReturn(true);

        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateTest_shouldBeNoContent() throws Exception {
        Mockito.when(personService.updatePerson(any())).thenReturn(true);

        mockMvc.perform(put("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isNoContent());
    }

    @Test
    void updateTest_shouldBeConflict() throws Exception {
        Mockito.when(personService.updatePerson(any())).thenReturn(false);

        mockMvc.perform(put("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isConflict());
    }

    @Test
    void deleteTest() throws Exception {
        Mockito.doNothing().when(personService).deletePersonById(anyLong());

        mockMvc.perform(delete("/person/15")).andExpect(status().isNoContent());
    }
}
