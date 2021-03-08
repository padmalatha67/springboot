package com.zemoso.springboot.springbootassignment.service.implementations;

import com.zemoso.springboot.springbootassignment.service.LoggedInUserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoggedInUserDetailsServiceImpl implements LoggedInUserDetailsService {

    String userName;
    String  roles;

    Map<String,String> userDetails = new HashMap<String,String>();

    @Override
    public Map<String,String> getUserDetails() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
            roles = ((UserDetails) principal).getAuthorities().toString();
            System.out.println("+++++++++++++++++++++++++");
            System.out.println(roles);

            String [] multipleRoles = roles.split(",");
            for (String role: multipleRoles){
                System.out.println(role);
                if (role.contains("PROVIDER")){
                    userDetails.remove("individual");
                    userDetails.put("provider",userName);
                    break;
                }
                else if(role.contains("INDIVIDUAL")){
                    userDetails.put("individual",userName);
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
        Map<String,String> userDetails = new HashMap<String,String>();
        userDetails = getUserDetails();

        System.out.println(userDetails);
        for (Map.Entry<String,String> entry : userDetails.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
            if (entry.getKey() == "provider") {
                name = entry.getValue();
            }
            else if(entry.getKey()=="individual"){
                name = entry.getValue();
            }
        }

        return name;
    }



}
