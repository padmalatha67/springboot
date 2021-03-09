package com.zemoso.springboot.springbootassignment.dao;

import com.zemoso.springboot.springbootassignment.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProviderRepository extends JpaRepository<Provider, Integer> {

    public Provider findByProviderName(String name);
}
