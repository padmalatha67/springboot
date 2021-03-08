package com.zemoso.springboot.springbootassignment.controller;


import com.zemoso.springboot.springbootassignment.dao.ProviderRepository;
import com.zemoso.springboot.springbootassignment.entity.Provider;
import com.zemoso.springboot.springbootassignment.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/providers")
public class ProviderController {

    private ProviderService providerService;


    //as we have only one constructor @Autowired is optional
    public ProviderController( ProviderService theProviderService) {
        providerService = theProviderService;
    }

    @GetMapping("/list")
    private String listOfProviders(Model theModel) {

        // get employees from db
        List<Provider> theProvider = providerService.findAll();

        // add to the spring model
        theModel.addAttribute("providers", theProvider);

        return "list-of-providers";

    }

    @GetMapping("/new")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Provider theProvider = new Provider();

        theModel.addAttribute("providers", theProvider);

        return "provider-form"; //go to templates/employees then employee-form
    }


    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("providerId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Provider theProvider = providerService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("providers", theProvider);

        // send over to our form
        return "provider-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("providers") @Valid Provider theProvider, BindingResult theBindingResult) {

        if (theBindingResult.hasErrors()) {
            return "provider-form";
        }
        else {
            providerService.save(theProvider);
            return "redirect:/providers/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("providerId") int theId) {

        // delete the employee
        providerService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/providers/list";

    }


}
