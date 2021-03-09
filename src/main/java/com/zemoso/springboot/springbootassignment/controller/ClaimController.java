package com.zemoso.springboot.springbootassignment.controller;


import com.zemoso.springboot.springbootassignment.SpringbootAssignmentApplication;
import com.zemoso.springboot.springbootassignment.entity.Claim;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.entity.User;
import com.zemoso.springboot.springbootassignment.service.*;
import com.zemoso.springboot.springbootassignment.service.implementations.LoggedInUserDetailsServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/claims")
public class ClaimController {

    private static final Logger LOGGER = LogManager.getLogger(SpringbootAssignmentApplication.class);

    private ClaimService claimService;

    private ProviderService providerService;

    private UserService userService;

    private LoggedInUserDetailsService userDetailsService;

    private static final String modelAttributeName = "claims";

    private static final String claimForm = "claim-form";

    //as we have only one constructor @Autowired is optional
    public ClaimController(ClaimService theClaimService, ProviderService theProviderService,
                           UserService theUserService, LoggedInUserDetailsService theUserDetailsService) {
        claimService = theClaimService;
        providerService = theProviderService;
        userService = theUserService;
        userDetailsService = theUserDetailsService;

    }

    @GetMapping("/list")
    public String listClaims(Model theModel) {

        LOGGER.info("fetch all calims");
        List<Claim> theEmployees = claimService.findAll();
        theModel.addAttribute(modelAttributeName, theEmployees);

        return "list-of-claims";

    }

    @GetMapping("/new")
    public String showFormForAdd( Model theModel) {

        LOGGER.info("Add new claim");
        Claim theClaim = new Claim();
        theModel.addAttribute(modelAttributeName, theClaim);

        return claimForm;
    }


    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("claimId") int theId,
                                    Model theModel) {


        LOGGER.info("Update existing claim or add ");
        Claim theClaim = claimService.findById(theId);
        theModel.addAttribute(modelAttributeName, theClaim);


        return claimForm;
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute(modelAttributeName) @Valid Claim claims, BindingResult theBindingResult) {

        LOGGER.info("Save a new claim");
        LOGGER.info("Binding results"+theBindingResult);
        LOGGER.error(theBindingResult.hasErrors());


        if (theBindingResult.hasErrors()) {
            return claimForm;
        }
        else {
            Date utilDate = new Date();
            Date sqlDate = new Date(utilDate.getTime());
            claims.setCreatedAt(sqlDate);
            claims.setDateOfService(LocalDate.now());
            claimService.save(claims);
            return "redirect:/claims/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("claimId") int theId) {

        LOGGER.info("delete a claim by id");
        claimService.deleteById(theId);
        return "redirect:/claims/list";

    }

    @GetMapping("/list/by/provider")
    public String findListOfClaimsRelatedToProvider(Model theModel) {

        LOGGER.info("List of claims related to provider");

        try {
                Provider provider;
                String providerName = userDetailsService.getName();

                provider = providerService.findByProviderName(providerName);
                LOGGER.info("fetch the provider object based on provider name");
                LOGGER.info(provider);

                List<Claim> providerClaims = claimService.findByProviderId(provider);
                LOGGER.info("fetch the provider claims based on provider id");
                LOGGER.info(providerClaims);

                theModel.addAttribute("providerClaims", providerClaims);
                return "list-of-provider-claims";

        }catch (NullPointerException e) {
            LOGGER.info("No claims present for the provider");
            return "no-claims-present";
        }

    }


    @GetMapping("/list/by/user")
    public String findListOfClaimsRelatedToUser(Model theModel) {

        LOGGER.info("List of claims related to user");

        try {

                User user;

                LoggedInUserDetailsServiceImpl loggedInUserDetails = new LoggedInUserDetailsServiceImpl();
                String userName = loggedInUserDetails.getName();


                user = userService.findByUserName(userName);


                List<Claim> userClaims = claimService.findByUserId(user);

                theModel.addAttribute("userClaims", userClaims);
                return "list-of-user-claims";

        }
        catch(NullPointerException e){
            LOGGER.info("No claims present for the user");
            return "no-claims-present";
        }
    }


}
