package com.tms.controller;


import com.tms.domain.Person;
import com.tms.service.PersonService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class PersonController {
    private final PersonService personService = new PersonService();

    public String getAll(HttpServletRequest request) {
        List<Person> resultList = personService.getAll(request);
        if (resultList.isEmpty()) {
            return "/emptyJsp.jsp";
        }
        return "/jspPage.jsp";
    }

    public String getById(HttpServletRequest request) {
        Person person = personService.getById(request);
        if (person == null) {
            return "/emptyJsp.jsp";
        }
        return "/jspPage.jsp";
    }

    public String createUser(HttpServletRequest request) {
        if (!personService.createUser(request)) {
            return "/emptyJsp.jsp";
        }
        return "/jspPage.jsp";
    }

    public String updateUser(HttpServletRequest request) {
        if (!personService.updateUser(request)) {
            return "/emptyJsp.jsp";
        }
        return "/jspPage.jsp";
    }

    public String deleteUser(HttpServletRequest request) {
        if (!personService.deleteUser(request)) {
            return "/emptyJsp.jsp";
        }
        return "/jspPage.jsp";
    }
}
