package com.training.spring.person.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.person.data.PersonDao;
import com.training.spring.person.model.Person;

@Service
public class PersonService {

    @Autowired
    private PersonDao pd;

    public void add(final Person person) {
        this.pd.save(person);
    }

    public void update(final Person personParam) {
        this.pd.save(personParam);
    }

    public Person getOne(final Long pidParam) {
        return this.pd.findById(pidParam)
                      .orElse(null);
    }

    public List<Person> getAll() {
        Iterable<Person> findAllLoc = this.pd.findAll();
        List<Person> personsLoc = new ArrayList<>();
        for (Person personLoc : findAllLoc) {
            personsLoc.add(personLoc);
        }
        return personsLoc;
    }

    public List<Person> getByName(final String nameParam) {
        return this.pd.findByName(nameParam);
    }

}
