package com.zemoso.springboot.springbootassignment.controller;

import com.zemoso.springboot.springbootassignment.entity.User;
import com.zemoso.springboot.springbootassignment.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    public UserService userService;

    private static final String modelAttributeName = "users";

    private static final String userForm = "user-form";

    //as we have only one constructor @Autowired is optional
    public UserController( UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/list")
    private String listClaims(Model theModel) {


        List<User> theUser = userService.findAll();
        theModel.addAttribute(modelAttributeName, theUser);

        return "list-of-users";

    }


    @GetMapping("/new")
    public String showFormForAdd( Model theModel) {


        User theUser = new User();
        theModel.addAttribute(modelAttributeName, theUser);

        return userForm;
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute(modelAttributeName) @Valid User users, BindingResult theBindingResult) {

        if (theBindingResult.hasErrors()) {
            return userForm;
        }
        else {
            Date utilDate = new Date();
            Date sqlDate = new Date(utilDate.getTime());
            users.setCreatedAt(sqlDate);
            userService.save(users);
            return "redirect:/users/list";
        }
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("userId") int theId,
                                    Model theModel) {


        User theUser = userService.findById(theId);
        theModel.addAttribute(modelAttributeName, theUser);


        return userForm;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int theId) {

        userService.deleteById(theId);
        return "redirect:/users/list";

    }
}
