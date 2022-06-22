package com.cly.finalproj.service;

import com.cly.finalproj.entity.ClyVehicle;
import com.cly.finalproj.mapper.ClyVehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    ClyVehicleMapper clyVehicleMapper;

    public List<ClyVehicle> getVehicleByOidAndType(int oid, String type){
        return clyVehicleMapper.getVehiclesByTypeAndOid(type, oid);
    }

    public List<ClyVehicle> getAllVehicles(){
        return clyVehicleMapper.getVehicles();
    }

    public ClyVehicle getVehicleById(int vin){
        return clyVehicleMapper.getVehicleById(vin);
    }
}
