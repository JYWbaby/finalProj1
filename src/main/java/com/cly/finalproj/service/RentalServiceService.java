package com.cly.finalproj.service;

import com.cly.finalproj.entity.ClyRentalService;
import com.cly.finalproj.mapper.ClyRentalServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceService {
    @Autowired
    ClyRentalServiceMapper clyRentalServiceMapper;

    public int insertRentalService(ClyRentalService rentalService){
        return clyRentalServiceMapper.addRentalService(rentalService);
    }

    public List<ClyRentalService> getRentalServicesByCustomer(int cid){
        return clyRentalServiceMapper.getRentalByCustomer(cid);
    }

    public List<ClyRentalService> getAllService(){
        return clyRentalServiceMapper.getAllRentals();
    }

    public ClyRentalService getServiceById(int sevId){
        return clyRentalServiceMapper.getRentalById(sevId);
    }

    public void deleteService(int sevId){
        clyRentalServiceMapper.deleteRental(sevId);
    }

    public void updateService(ClyRentalService rentalService){
        clyRentalServiceMapper.updateRentalService(rentalService);
    }
}
