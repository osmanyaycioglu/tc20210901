package com.training.spring.person.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.model.Person;
import com.training.spring.person.service.PersonService;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonRest {

    @Autowired
    private PersonService ps;

    // @PutMapping
    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        this.ps.add(person);
        return "OK";
    }

    // @PatchMapping
    @PostMapping("/update")
    public String update(@Validated @RequestBody final Person person) {
        this.ps.update(person);
        return "OK";
    }

}
