package com.zemoso.springboot.springbootassignment.service.implementations;


import com.zemoso.springboot.springbootassignment.dao.ClaimRepository;
import com.zemoso.springboot.springbootassignment.entity.Claim;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.entity.User;
import com.zemoso.springboot.springbootassignment.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
    JPA proivdes @Transactional so no need of that
 */

@Service
public class ClaimServiceImpl implements ClaimService {

    private ClaimRepository claimRepository;

    @Autowired
    public ClaimServiceImpl(ClaimRepository theClaimRepository) {
        claimRepository = theClaimRepository;
    }

    @Override
    public List<Claim> findAll() {
        return claimRepository.findAll();
    }

    @Override
    public Claim findById(int theId) {
        Optional<Claim> result = claimRepository.findById(theId);

        Claim theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public void save(Claim theClaim) {
        claimRepository.save(theClaim);
    }

    @Override
    public void deleteById(int theId) {
        claimRepository.deleteById(theId);
    }

    @Override
    public List<Claim> findByProviderId(Provider providerId) {
        return claimRepository.findByProviderId(providerId);

    }

    @Override
    public List<Claim> findByUserId(User employeeId) {
        return claimRepository.findByUserId(employeeId);
    }


}
