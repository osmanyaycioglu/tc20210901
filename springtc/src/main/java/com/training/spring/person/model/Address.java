package com.training.spring.person.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "generate_id",
                pkColumnName = "uid",
                pkColumnValue = "address",
                initialValue = 0,
                allocationSize = 1)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "generate_id")
    private Long   addId;

    private String city;
    private String street;

    public Long getAddId() {
        return this.addId;
    }

    public void setAddId(final Long addIdParam) {
        this.addId = addIdParam;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String streetParam) {
        this.street = streetParam;
    }


}
