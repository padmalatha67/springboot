package com.zemoso.springboot.springbootassignment.dao;

import com.zemoso.springboot.springbootassignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    public  User findByUserName(String name);
}
