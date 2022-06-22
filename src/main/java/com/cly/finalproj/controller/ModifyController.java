package com.cly.finalproj.controller;

import com.cly.finalproj.entity.ClyRentalService;
import com.cly.finalproj.entity.User;
import com.cly.finalproj.helper.ModifyForm;
import com.cly.finalproj.helper.PaymentForm;
import com.cly.finalproj.helper.RentHelper;
import com.cly.finalproj.service.RentalServiceService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ModifyController {

    @Autowired
    RentHelper rentHelper;
    @Autowired
    RentalServiceService rentalServiceService;

    @GetMapping(value = "/edit-order/{sevId}")
    public String modifyPage(Authentication authentication, @PathVariable Integer sevId,
                             @ModelAttribute("modifyForm") ModifyForm modifyForm,
                             Model model){
        model.addAttribute("authentication", authentication);
        rentHelper.setSevId(sevId);
        return "modifyOrder";
    }

    @PostMapping("/modify")
    public String modifySubmission(Authentication authentication, @ModelAttribute("modifyForm") ModifyForm modifyForm,
                                    Model model) throws IOException {
        model.addAttribute("authentication", authentication);

        Integer sevId = rentHelper.getSevId();
        ClyRentalService rentalService = rentalServiceService.getServiceById(sevId);

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        String startDate = modifyForm.getStartDate();
        String endDate = modifyForm.getEndDate();
        String endMeter = modifyForm.getEndMeter();
        String startMeter = modifyForm.getStartMeter();

        if(startDate != null){
            try{
                Date t = ft.parse(startDate);
                rentalService.setPickupDate(t);
            }
            catch (ParseException e){

            }
        }

        if(endDate != null){
            try{
                Date t = ft.parse(endDate);
                rentalService.setDropDate(t);
            }
            catch (ParseException e){

            }
        }

        if(startMeter != null){
            rentalService.setStartMeter(new BigDecimal(startMeter));
        }

        if(endMeter != null){
            rentalService.setEndMeter(new BigDecimal(endMeter));
        }

        rentalServiceService.updateService(rentalService);

        return "deletePage";
    }
}
