package com.zemoso.springboot.springbootassignment;

import com.zemoso.springboot.springbootassignment.dao.ProviderRepository;
import com.zemoso.springboot.springbootassignment.dao.UserRepository;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.entity.User;
import com.zemoso.springboot.springbootassignment.service.ProviderService;
import com.zemoso.springboot.springbootassignment.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)

public class UserServiceTests {

    @Autowired
    UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void testFindAllProviders(){

        Date date = new Date();
        when(userRepository.findAll()).thenReturn(Stream.
                of(new User("user1","user1@gmail.com")).collect(Collectors.toList()));
        assertEquals(1,userService.findAll().size());
    }

    @Test
    public void testSaveProvider(){

        User user = new User("padma","padma@gmail.com");
        when(userRepository.save(nullable(User.class))).thenReturn(user);
        userService.save(user);
        verify(userRepository,times(1)).save(nullable(User.class));

    }

    @Test
    public void testUpdateProvider() {

        User user = new User("padma","padma@gmail.com");

        when(userRepository.findByUserName("padma")).thenReturn(user);

       // Claim claim1 = claimRepository.findByClaimId(1);
        user.setUserName("padma_new");
        assertEquals("padma_new",user.getUserName());

    }

    @Test
    public void testDeleteProvider(){

        doNothing().when(userRepository).deleteById(anyInt());
        userService.deleteById(anyInt());
        verify(userRepository,times(1)).deleteById(anyInt());


    }



}
