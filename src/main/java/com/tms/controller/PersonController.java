package com.tms.controller;

import com.tms.domain.Person;
import com.tms.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/{id}")
    public String getPersonById(Model model, @PathVariable Long id) {
        Person resultPerson = personService.getPersonById(id);
        if (resultPerson.getId() != null) {
            model.addAttribute("result", resultPerson);
            return "jspPage";
        }
        return "emptyJsp";
    }
}
