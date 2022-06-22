package com.cly.finalproj.controller;

import com.cly.finalproj.entity.ClyVehicle;
import com.cly.finalproj.helper.RentHelper;
import com.cly.finalproj.service.UserService;
import com.cly.finalproj.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @Autowired
    UserService userService;

    @Autowired
    private RentHelper rentHelper;

    @GetMapping(value = "/VehicleList/{type}")
    public String VehicleTypeHandler(Authentication authentication, @PathVariable("type") String type,
                                     Model model){

        List<ClyVehicle> vehicles = vehicleService.getVehicleByOidAndType(rentHelper.getPickOffice(), type);

        model.addAttribute("vehicles", vehicles);
        model.addAttribute("authentication", authentication);

        return "vehicle_list";
    }
}
