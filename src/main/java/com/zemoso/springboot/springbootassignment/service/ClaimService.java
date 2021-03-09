package com.zemoso.springboot.springbootassignment.service;

import com.zemoso.springboot.springbootassignment.entity.Claim;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.entity.User;

import java.util.List;

public interface ClaimService {

    public List<Claim> findAll();

    public Claim findById(int theId);

    public void save(Claim theEmployee);

    public void deleteById(int theId);


    public List<Claim> findByProviderId(Provider providerId);


    public List<Claim> findByUserId(User userId);
}
