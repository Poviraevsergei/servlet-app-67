package com.tms.controller;

import com.tms.domain.Person;
import com.tms.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    public final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        List<Person> resultList = personService.getAll();
        if (!resultList.isEmpty()) {
            model.addAttribute("result", resultList);
            return "jspPage";
        }
        return "emptyJsp";
    }

    @GetMapping
    public String getPersonById(Model model, @RequestParam("id") Long id) {
        Person resultPerson = personService.getPersonById(id);
        if (resultPerson.getId() != null) {
            model.addAttribute("result", resultPerson);
            return "jspPage";
        }
        return "emptyJsp";
    }

    @GetMapping("/is-valid")
    public String checkValidationPerson(@Valid @ModelAttribute Person person, BindingResult bindingResult, Model model) {
        List<ObjectError> errors = bindingResult.getAllErrors();
        if (!bindingResult.hasErrors()) {
            return "emptyJsp";
        }
        model.addAttribute("result", errors);
        return "jspPage";
    }
}
