package com.zemoso.springboot.springbootassignment;

import com.zemoso.springboot.springbootassignment.dao.ClaimRepository;
import com.zemoso.springboot.springbootassignment.dao.ProviderRepository;
import com.zemoso.springboot.springbootassignment.entity.Claim;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.entity.User;
import com.zemoso.springboot.springbootassignment.service.ClaimService;
import com.zemoso.springboot.springbootassignment.service.ProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)

public class ProviderServiceTests {

    @Autowired
    ProviderService providerService;

    @MockBean
    private ProviderRepository providerRepository;


    @Test
    public void testFindAllProviders(){

        Date date = new Date();
        when(providerRepository.findAll()).thenReturn(Stream.
                of(new Provider("provider1","provider1@gmail.com","general surgey")).collect(Collectors.toList()));
        assertEquals(1,providerService.findAll().size());
    }

    @Test
    public void testSaveProvider(){

        Provider provider = new Provider("padma","padma@gmail.com","general surgey");
        when(providerRepository.save(nullable(Provider.class))).thenReturn(provider);
        providerService.save(provider);
        verify(providerRepository,times(1)).save(nullable(Provider.class));

    }

    @Test
    public void testUpdateProvider() {

        Provider provider = new Provider("padma","padma@gmail.com","general surgey");

        when(providerRepository.findByProviderName("padma")).thenReturn(provider);

       // Claim claim1 = claimRepository.findByClaimId(1);
        provider.setProviderName("padma_new");
        assertEquals("padma_new",provider.getProviderName());

    }

    @Test
    public void testDeleteProvider(){

        doNothing().when(providerRepository).deleteById(anyInt());
        providerService.deleteById(anyInt());
        verify(providerRepository,times(1)).deleteById(anyInt());


    }



}
