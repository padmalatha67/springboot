package com.zemoso.springboot.springbootassignment.service;

import com.zemoso.springboot.springbootassignment.entity.User;

import java.util.List;

public interface UserService {

   public void save(User theUser);

   public User findByUserName(String name);

   List<User> findAll();

   public void deleteById(int theId);

   public User findById(int theId);
}
