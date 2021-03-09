package com.zemoso.springboot.springbootassignment.service.implementations;

import com.zemoso.springboot.springbootassignment.SpringbootAssignmentApplication;
import com.zemoso.springboot.springbootassignment.service.LoggedInUserDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoggedInUserDetailsServiceImpl implements LoggedInUserDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(LoggedInUserDetailsServiceImpl.class);

    String userName;
    String  roles;

    private static final String roleName = "individual";



    @Override
    public Map<String,String> getUserDetails() {
        Map<String,String> userDetails = new HashMap<>();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
            roles = ((UserDetails) principal).getAuthorities().toString();
            LOGGER.info(roles);

            String [] multipleRoles = roles.split(",");
            for (String role: multipleRoles){
                LOGGER.info(role);
                if (role.contains("PROVIDER")){
                    userDetails.remove(roleName);
                    userDetails.put("provider",userName);
                    break;
                }
                else if(role.contains("INDIVIDUAL")){
                    userDetails.put(roleName,userName);
                }
            }

        } else {
            userDetails.put("error","error");

        }
        return userDetails;
    }

    @Override
    public String getName(){
        String name = null;
        Map<String,String> userDetails = new HashMap<>();
        userDetails = getUserDetails();

        LOGGER.info(userDetails);
        for (Map.Entry<String,String> entry : userDetails.entrySet()) {
            LOGGER.info("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
                name = entry.getValue();
        }

        return name;
    }



}
