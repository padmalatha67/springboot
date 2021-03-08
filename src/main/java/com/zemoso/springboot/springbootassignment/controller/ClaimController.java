package com.zemoso.springboot.springbootassignment.controller;


import com.zemoso.springboot.springbootassignment.entity.Claim;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.entity.User;
import com.zemoso.springboot.springbootassignment.service.*;
import com.zemoso.springboot.springbootassignment.service.implementations.LoggedInUserDetailsServiceImpl;
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

    private ClaimService claimService;

    private ProviderService providerService;

    private UserService userService;

    private LoggedInUserDetailsService userDetailsService;

    //as we have only one constructor @Autowired is optional
    public ClaimController(ClaimService theClaimService, ProviderService theProviderService,
                           UserService theUserService, LoggedInUserDetailsService theUserDetailsService) {
        claimService = theClaimService;
        providerService = theProviderService;
        userService = theUserService;
        userDetailsService = theUserDetailsService;

    }

    @GetMapping("/list")
    private String listClaims(Model theModel) {

       // LOGGER.info("")
        List<Claim> theEmployees = claimService.findAll();
        theModel.addAttribute("claims", theEmployees);

        return "list-of-claims";

    }

    @GetMapping("/new")
    public String showFormForAdd( Model theModel) {


        Claim theClaim = new Claim();
        theModel.addAttribute("claims", theClaim);

        return "claim-form";
    }


    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("claimId") int theId,
                                    Model theModel) {


        Claim theClaim = claimService.findById(theId);
        theModel.addAttribute("claims", theClaim);


        return "claim-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("claims") @Valid Claim claims, BindingResult theBindingResult) {

        System.out.println("Procedure code: |" + claims.getProcedureCode() + "|");
        System.out.println(theBindingResult.hasErrors());
        System.out.println(theBindingResult);
        System.out.println();

        if (theBindingResult.hasErrors()) {
            return "claim-form";
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

        claimService.deleteById(theId);
        return "redirect:/claims/list";

    }

    @GetMapping("/list/by/provider")
    public String findListOfClaimsRelatedToProvider(Model theModel) {

        try {
                int providerId = 0;
                Provider provider = new Provider();
                String providerName = userDetailsService.getName();

                provider = providerService.findByProviderName(providerName);

                List<Claim> providerClaims = claimService.findByProviderId(provider);
                theModel.addAttribute("providerClaims", providerClaims);
                return "list-of-provider-claims";

        }catch (NullPointerException e) {
            return "no-claims-present";
        }

    }


    @GetMapping("/list/by/user")
    public String findListOfClaimsRelatedToUser(Model theModel) {

        try {
                int providerId = 0;
                User user = new User();

                LoggedInUserDetailsServiceImpl loggedInUserDetails = new LoggedInUserDetailsServiceImpl();
                String userName = loggedInUserDetails.getName();


                user = userService.findByUserName(userName);


                List<Claim> userClaims = claimService.findByUserId(user);

                theModel.addAttribute("userClaims", userClaims);
                return "list-of-user-claims";

        }
        catch(NullPointerException e){
            return "no-claims-present";
        }
    }


}
