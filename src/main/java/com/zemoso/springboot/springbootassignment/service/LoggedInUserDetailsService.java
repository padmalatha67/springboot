package com.zemoso.springboot.springbootassignment.service;

import java.util.Map;

public interface LoggedInUserDetailsService {
    public Map<String,String> getUserDetails();
    public String getName();
}
