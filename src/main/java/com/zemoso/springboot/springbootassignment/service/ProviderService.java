package com.zemoso.springboot.springbootassignment.service;

import com.zemoso.springboot.springbootassignment.entity.Provider;

import java.util.List;

public interface ProviderService {

    public List<Provider> findAll();

    public Provider findById(int theId);

    public void save(Provider theProvider);

    public void deleteById(int theId);

    public Provider findByProviderName(String name);
}
