package com.training.spring.person.rest;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
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
    @PreAuthorize("hasAnyRole('VIEWER')")
    public List<Person> getAll() {
        return this.ps.getAll();
    }

    @GetMapping("/get/all2")
    public List<Person> getAll2(final Principal principal) {
        UsernamePasswordAuthenticationToken userLoc = (UsernamePasswordAuthenticationToken) principal;
        Collection<GrantedAuthority> authoritiesLoc = userLoc.getAuthorities();
        System.out.println("Auth group : " + authoritiesLoc);
        String nameLoc = principal.getName();
        System.out.println(nameLoc);
        return this.ps.getAll();
    }

}
