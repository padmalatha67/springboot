package com.zemoso.springboot.springbootassignment.dao;

import com.zemoso.springboot.springbootassignment.entity.Claim;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

    List<Claim> findByProviderId(Provider providerId);

    List<Claim> findByUserId(User userId);

    Claim findByClaimId(int claimId);

}
