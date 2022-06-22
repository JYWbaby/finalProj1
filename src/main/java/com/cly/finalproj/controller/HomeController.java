package com.cly.finalproj.controller;


import com.cly.finalproj.helper.PaymentForm;
import com.cly.finalproj.helper.RentHelper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {





    @GetMapping
    public String getHome(Authentication authentication, @ModelAttribute("newPayment") PaymentForm newPayment, Model model){
        model.addAttribute("authentication", authentication);
        return "index";
    }

}
