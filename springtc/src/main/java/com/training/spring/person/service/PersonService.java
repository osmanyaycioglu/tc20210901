package com.training.spring.person.service;

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

}
