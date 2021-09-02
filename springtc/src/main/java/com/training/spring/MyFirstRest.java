package com.training.spring;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deneme.MyBean;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.spring.di.IGreet;
import com.training.spring.person.model.Person;

@RestController
@RequestMapping("/first")
//@RequestScope
//@SessionScope
//@ApplicationScope
public class MyFirstRest {

    @Autowired
    @Qualifier("dyn")
    //@Qualifier("prof")
    private IGreet greet;

    @Autowired
    private MyBean mBean;


    @GetMapping("/hello/{xyz}/{abc}")
    public String hello(@PathVariable("xyz") final String name,
                        @PathVariable("abc") final String surname) {
        return this.greet.greet("Hello 1 : " + name + " " + surname);
    }

    @GetMapping("/hello2")
    public String hello22(@RequestParam("xyz") final String name,
                          @RequestParam("abc") final String surname) {
        return this.greet.greet("Hello 2 : " + name + " " + surname);
    }

    @PostMapping("/hello3")
    public String hello23(@RequestBody final Person personParam) {
        return this.greet.greet("Hello 2 : "
                                + personParam.getName()
                                + " "
                                + personParam.getSurname()
                                + " "
                                + personParam.getAge());
    }

    @PostMapping("/hello4")
    public Person hello24(@RequestBody final Person personParam) {
        personParam.setAge(99);
        return personParam;
    }

    @PostMapping("/hello5")
    public ResponseEntity<Person> hello25(@RequestBody final Person personParam) {
        personParam.setAge(99);
        return ResponseEntity.status(200)
                             .header("my",
                                     "header")
                             .body(personParam);
    }

    @PostMapping("/hello6")
    public ResponseEntity<?> hello26(final HttpServletRequest req) throws JsonParseException, JsonMappingException, IOException {
        String parameterLoc = req.getParameter("command");
        switch (parameterLoc) {
            case "add":
                req.getParameter("xyz");
                ServletInputStream inputStreamLoc = req.getInputStream();
                ObjectMapper mapperLoc = new ObjectMapper();
                Person readValueLoc = mapperLoc.readValue(inputStreamLoc,
                                                          Person.class);
                break;
            case "delete":

                //
                break;
            default:
                break;
        }

        return ResponseEntity.status(200)
                             .header("my",
                                     "header")
                             .body("SUCCESS");
    }


    @GetMapping("/hello1")
    public String hello1() {
        return "Hello world GET";
    }

    @PostMapping("/hello1")
    public String hello1a() {
        return "Hello world POST";
    }

    @PutMapping("/hello1")
    public String hello1b() {
        return "Hello world PUT";
    }

    @PatchMapping("/hello1")
    public String hello1c() {
        return "Hello world PATCH";
    }

    @DeleteMapping("/hello1")
    public String hello1d() {
        return "Hello world DELETE";
    }


    @GetMapping("/hello100")
    public String hello2() {
        return this.mBean.hello();
    }

}
