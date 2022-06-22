package com.cly.finalproj.controller;

import com.cly.finalproj.entity.*;
import com.cly.finalproj.helper.InfoForm;
import com.cly.finalproj.helper.PaymentForm;
import com.cly.finalproj.service.CustomerService;
import com.cly.finalproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Date;

@Controller
public class CustomerController {
    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/personalInfo")
    public String getInfoPage(Authentication authentication, @ModelAttribute("newInfo") InfoForm newInfo, Model model){
        model.addAttribute("authentication", authentication);
        return "customerInfo";
    }

    @PostMapping("/personalInfo/{type}")
    public String paymentSubmission(Authentication authentication, @PathVariable Integer type, @ModelAttribute("newInfo") InfoForm newInfo,
                                    Model model) throws IOException {
        model.addAttribute("authentication", authentication);

        ClyCustomer customer = new ClyCustomer();

        customer.setCstreet(newInfo.getStreet());
        customer.setCcity(newInfo.getCity());
        customer.setCstate(newInfo.getState());
        customer.setCcountry(newInfo.getCountry());
        customer.setCzip(newInfo.getZip());
        customer.setCemail(newInfo.getEmail());
        customer.setCphone(newInfo.getPhone());

        if(type == 1){  //individual
            customer.setCtype("I");
            customerService.insertCustomer(customer);

            ClyIndividual individual = new ClyIndividual();
            individual.setCid(customer.getCid());
            individual.setFName(newInfo.getFname());
            individual.setLName(newInfo.getLname());
            individual.setInsComp(newInfo.getInsComp());
            individual.setInsNum(newInfo.getInsNum());
            individual.setDriveLicense(newInfo.getDriveLicense());
            customerService.insertIndividual(individual);


        }
        else{  //corp
            customer.setCtype("C");
            customerService.insertCustomer(customer);

            ClyCorp corp = new ClyCorp();
            corp.setCid(customer.getCid());
            corp.setCorpName(newInfo.getCorpName());
            corp.setRegNum(newInfo.getRegNum());
            corp.setEmpId(newInfo.getEmpId());
            customerService.insertCorp(corp);
        }

        String username = authentication.getName();
        User user = userService.getUser(username);
        user.setCid(customer.getCid());
        userService.updateUser(user);

        return "resultPage";

    }
}
