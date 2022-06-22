package com.cly.finalproj.controller;

import com.cly.finalproj.entity.*;
import com.cly.finalproj.helper.PaymentForm;
import com.cly.finalproj.service.*;
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
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    UserService userService;
    @Autowired
    RentalServiceService rentalServiceService;
    @Autowired
    CustomerService customerService;
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    OfficeService officeService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/customerOrder")
    public String OrderPage(Authentication authentication, Model model){
        model.addAttribute("authentication", authentication);


        String username = authentication.getName();
        User user = userService.getUser(username);
        if(user.getCid() == null)
            return "failPage";
        Integer cid = user.getCid();
        List<ClyRentalService> serviceList = rentalServiceService.getRentalServicesByCustomer(cid);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("invoiceService", invoiceService);
        model.addAttribute("officeService", officeService);
        model.addAttribute("vehicleService", vehicleService);
        return "customerOrder";
    }

    @GetMapping(value = "/adminOrder")
    public String checkOrder(Authentication authentication, Model model){
        model.addAttribute("authentication", authentication);
        String username = authentication.getName();
        User user = userService.getUser(username);
        Integer cid = user.getCid();
        List<ClyRentalService> serviceList = rentalServiceService.getAllService();
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("invoiceService", invoiceService);
        model.addAttribute("officeService", officeService);
        model.addAttribute("vehicleService", vehicleService);
        return "adminOrder";
    }

    @GetMapping(value = "/delete-order/{sevId}")
    public String dropLocationPage(Authentication authentication, @PathVariable Integer sevId,
                                   Model model){
        model.addAttribute("authentication", authentication);
        paymentService.deletePayment(sevId);
        invoiceService.deleteInvoice(sevId);
        rentalServiceService.deleteService(sevId);

        return "deletePage";
    }


}
