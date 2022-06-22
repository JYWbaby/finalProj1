package com.cly.finalproj.controller;

import com.cly.finalproj.entity.*;
import com.cly.finalproj.helper.PaymentForm;
import com.cly.finalproj.helper.RentHelper;
import com.cly.finalproj.service.PaymentService;
import com.cly.finalproj.service.RentalServiceService;
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
import java.math.BigDecimal;
import java.util.Date;

@Controller
public class PaymentController {
    @Autowired
    UserService userService;
    @Autowired
    RentHelper rentHelper;
    @Autowired
    PaymentService paymentService;
    @Autowired
    RentalServiceService rentalServiceService;


    @GetMapping(value = "/payment/{oid}")
    public String dropLocationPage(Authentication authentication, @PathVariable Integer oid, @ModelAttribute("newPayment") PaymentForm newPayment,
                                   Model model) {
        model.addAttribute("authentication", authentication);

        rentHelper.setDropLocation(oid);

        String username = authentication.getName();
        User user = userService.getUser(username);

        ClyRentalService rentalService = new ClyRentalService();
        rentalService.setPickupDate(new Date());
        rentalService.setDropDate(new Date());
        rentalService.setStartMeter(new BigDecimal(0));
        rentalService.setEndMeter(new BigDecimal(0));
        rentalService.setDMeterLimit(new BigDecimal(100));
        rentalService.setCid(user.getCid());
        rentalService.setVin(rentHelper.getVin());
        rentalService.setOid(rentHelper.getPickOffice());
        rentalService.setOid2(rentHelper.getDropLocation());
        rentalServiceService.insertRentalService(rentalService);

        rentHelper.setSevId(rentalService.getSevId());

        model.addAttribute("rentalService", rentalService);

        return "payment";
    }


    @PostMapping("/paymentSubmit/{type}")
    public String paymentSubmission(Authentication authentication, @PathVariable Integer type, @ModelAttribute("newPayment") PaymentForm newPayment,
                          Model model) throws IOException {
        model.addAttribute("authentication", authentication);

        ClyPayment payment = new ClyPayment();
        Integer sevId = rentHelper.getSevId();
        if(type == 1){  //giftcard
            payment.setMethod("G");
            payment.setCardNum(newPayment.getCardNumber());
            payment.setPayDate(new Date());
            payment.setSevId(sevId);
            paymentService.addPayment(payment);
        }
        else if(type == 2){  //debit card
            payment.setMethod("D");
            payment.setCardNum(newPayment.getCardNumber());
            payment.setPayDate(new Date());
            payment.setSevId(sevId);
            paymentService.addPayment(payment);
            ClyDebit debit = new ClyDebit();
            debit.setSevId(sevId);
            debit.setPin(Integer.parseInt(newPayment.getPin()));
            paymentService.addDebit(debit);
        }
        else{   //credit card
            payment.setMethod("C");
            payment.setCardNum(newPayment.getCardNumber());
            payment.setPayDate(new Date());
            payment.setSevId(sevId);
            paymentService.addPayment(payment);
            ClyCredit credit = new ClyCredit();
            credit.setSevId(sevId);
            credit.setCvv(Short.parseShort(newPayment.getCvv()));
            credit.setValidDate(newPayment.getValidDate());
            paymentService.addCredit(credit);
        }





        return "resultPage";

    }



}
