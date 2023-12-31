package com.tms.controller;

import com.tms.domain.Person;
import com.tms.service.PersonService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/person")
public class PersonController {
    public final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        List<Person> resultList = personService.getAll();
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        Optional<Person> person = personService.getPersonById(id);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @GetMapping("/findByAge")
    public ResponseEntity<List<Person>> findAllByAge(@RequestParam("age") Integer age) {
        List<Person> persons = personService.findAllByAge(age);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Person person) {
        return new ResponseEntity<>(personService.createPerson(person) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody Person person) {
        return new ResponseEntity<>(personService.updatePerson(person) ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }

    @PutMapping("/{age}/{id}")
    public ResponseEntity<HttpStatus> updateAge(@PathVariable Integer age, @PathVariable Long id) {
        personService.updateAge(age, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаляет пользователя из бд",
            description = "Берет id, идет в бд и удаляет запись с этой id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Неверный ID"),
            @ApiResponse(responseCode = "404", description = "id не найдено"),
            @ApiResponse(responseCode = "204", description = "Значит что успешно удалили")})
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "Это id person который хотим удалить") @PathVariable("id") Long id) {
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
