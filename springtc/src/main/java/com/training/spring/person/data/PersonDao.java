package com.training.spring.person.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.spring.person.model.Person;

public interface PersonDao extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameIn(List<String> name);

    List<Person> findBySurname(String surname);

    List<Person> findByNameAndSurnameOrderByNameAsc(String name,
                                                    String surname);

    @Query("select p from Person p where p.name=?1")
    List<Person> searchName(String name);

    @Query("select p from Person p where p.name=:isim")
    List<Person> searchName2(@Param("isim") String name);

    @Query(value = "select * from kisi p where p.isim=?1", nativeQuery = true)
    List<Person> searchName3(String name);


}
