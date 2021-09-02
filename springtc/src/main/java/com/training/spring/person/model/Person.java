package com.training.spring.person.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long    perId;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String  name;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String  surname;
    @Max(200)
    @Min(18)
    private Integer age;
    private Integer weight;
    private Integer height;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(final Integer ageParam) {
        this.age = ageParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public Long getPerId() {
        return this.perId;
    }

    public void setPerId(final Long perIdParam) {
        this.perId = perIdParam;
    }
}
