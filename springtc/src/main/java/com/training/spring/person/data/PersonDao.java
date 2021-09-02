package com.training.spring.person.data;

import org.springframework.data.repository.CrudRepository;

import com.training.spring.person.model.Person;

public interface PersonDao extends CrudRepository<Person, Long> {

}
