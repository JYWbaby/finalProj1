package com.cly.finalproj.controller;

import com.cly.finalproj.helper.RentHelper;
import com.cly.finalproj.service.UserService;
import com.cly.finalproj.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VehicleTypeController {

    @Autowired
    UserService userService;
    @Autowired
    VehicleTypeService vehicleTypeService;

    @Autowired
    private RentHelper rentHelper;

    @GetMapping(value = "/VehicleType/{oid}")
    public String VehicleTypeHandler(Authentication authentication, @PathVariable Integer oid,
                             Model model){

        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypesByOid(oid));
        model.addAttribute("authentication", authentication);
        rentHelper.setPickOffice(oid);

        return "vehicle_type";
    }

}
