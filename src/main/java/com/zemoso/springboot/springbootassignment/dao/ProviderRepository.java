package com.zemoso.springboot.springbootassignment.dao;

import com.zemoso.springboot.springbootassignment.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {

    public Provider findByProviderName(String name);
}
