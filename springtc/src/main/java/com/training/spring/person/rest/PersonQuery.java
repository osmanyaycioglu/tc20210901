package com.training.spring.person.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.model.Person;
import com.training.spring.person.service.PersonService;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQuery {

    @Autowired
    private PersonService ps;

    @GetMapping("/get/by/name")
    public List<Person> getByName(@RequestParam("name") final String name) {
        return this.ps.getByName(name);
    }

    @GetMapping("/get/one")
    public Person getOne(@RequestParam("pid") final Long pid) {
        return this.ps.getOne(pid);
    }

    @GetMapping("/get/all")
    public List<Person> getAll() {
        return this.ps.getAll();
    }

}
