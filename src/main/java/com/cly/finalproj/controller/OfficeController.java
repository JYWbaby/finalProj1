package com.cly.finalproj.controller;

import com.cly.finalproj.entity.ClyRentalService;
import com.cly.finalproj.entity.User;
import com.cly.finalproj.helper.PaymentForm;
import com.cly.finalproj.helper.RentHelper;
import com.cly.finalproj.service.OfficeService;
import com.cly.finalproj.service.RentalServiceService;
import com.cly.finalproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class OfficeController {

    @Autowired
    UserService userService;
    @Autowired
    OfficeService officeService;
    @Autowired
    private RentHelper rentHelper;



    @GetMapping(value = "/pickupLocation")
    public String pickupLocationPage(Authentication authentication,
                             Model model){
        model.addAttribute("authentication", authentication);
        String username = authentication.getName();
        User user = userService.getUser(username);
        if(user.getCid() == null)
            return "failPage";
        model.addAttribute("offices", officeService.getAllOffice());
        return "office_list";
    }

    @GetMapping(value = "/dropLocation/{vin}")
    public String dropLocationPage(Authentication authentication, @PathVariable Integer vin, @ModelAttribute("newPayment") PaymentForm newPayment,
                             Model model){


        rentHelper.setVin(vin);
        model.addAttribute("authentication", authentication);
        model.addAttribute("offices", officeService.getAllOffice());



        return "office_list2";
    }
}
