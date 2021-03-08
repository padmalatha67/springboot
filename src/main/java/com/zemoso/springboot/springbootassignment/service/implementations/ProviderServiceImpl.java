package com.zemoso.springboot.springbootassignment.service.implementations;


import com.zemoso.springboot.springbootassignment.dao.ProviderRepository;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
/*
    JPA proivdes @Transactional so no need of that
 */

@Service
public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository providerRepository;

    public ProviderServiceImpl(){

    }

    @Autowired
    public ProviderServiceImpl(ProviderRepository theProviderRepository) {
        providerRepository = theProviderRepository;
    }

    @Override
    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Provider findById(int theId) {
        Optional<Provider> result = providerRepository.findById(theId);

        Provider theProvider = null;
        theProvider = result.get();

       if (result.isPresent()) {
            theProvider = result.get();
        }
       // else {
            // we didn't find the employee
            //throw new RuntimeException("Did not find provider id - " + theId);

       // }

        return theProvider;
    }

    @Override
    public void save(Provider theProvider) {
        providerRepository.save(theProvider);
    }

    @Override
    public void deleteById(int theId) {
        providerRepository.deleteById(theId);
    }



    @Override
    public Provider findByProviderName(String name) {
        System.out.println("============================");
        System.out.println(name);
        return providerRepository.findByProviderName(name);
    }


}
