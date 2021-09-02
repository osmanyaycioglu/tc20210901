package com.training.spring.person.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.model.Person;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQuery {

    @GetMapping("/get/by/name")
    public Person getByName(@RequestParam("name") final String name) {
        return null;
    }

}
