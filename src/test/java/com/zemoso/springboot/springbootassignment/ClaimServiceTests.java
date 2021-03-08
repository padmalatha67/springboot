package com.zemoso.springboot.springbootassignment;

import com.zemoso.springboot.springbootassignment.dao.ClaimRepository;
import com.zemoso.springboot.springbootassignment.entity.Claim;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.entity.User;
import com.zemoso.springboot.springbootassignment.service.ClaimService;
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

public class ClaimServiceTests {

    @Autowired
    ClaimService claimService;

    @MockBean
    private ClaimRepository claimRepository;

    Provider provider = new Provider("padma","padma@gmail.com","general surgey");
    User user = new User("testuser","testuser@gmail.com");

    @Test
    public void testFindAllClaims(){

        Date date = new Date();
        when(claimRepository.findAll()).thenReturn(Stream.
                of(new Claim(1,"ICD-9", "joint pain",
                        provider, LocalDate.now(), user, 140000, date)).collect(Collectors.toList()));
        assertEquals(1,claimService.findAll().size());
    }

    @Test
    public void testSaveClaim(){
        Date date = new Date();
        Claim claim = new Claim(1, "ICD-9", "joint pain",
                provider, LocalDate.now(), user, 140000, date);
        when(claimRepository.save(nullable(Claim.class))).thenReturn(claim);
        claimService.save(claim);
        verify(claimRepository,times(1)).save(nullable(Claim.class));

    }

    @Test
    public void testUpdateClaim() {

        Date date = new Date();
        Claim claim = new Claim(1, "ICD-9", "joint pain",
                provider, LocalDate.now(), user, 140000, date);

        when(claimRepository.findByClaimId(1)).thenReturn(claim);

       // Claim claim1 = claimRepository.findByClaimId(1);
        claim.setCost(145000);
        assertEquals(145000,claim.getCost());

    }

    @Test
    public void testDeleteClaim(){

        doNothing().when(claimRepository).deleteById(anyInt());
        claimService.deleteById(anyInt());
        verify(claimRepository,times(1)).deleteById(anyInt());


    }



}
