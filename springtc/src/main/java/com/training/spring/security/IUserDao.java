package com.training.spring.security;

import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<Kullanici, String> {

}
