package com.cly.finalproj.service;

import com.cly.finalproj.entity.ClyVehicleType;
import com.cly.finalproj.mapper.ClyVehicleMapper;
import com.cly.finalproj.mapper.ClyVehicleTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {
    @Autowired
    ClyVehicleTypeMapper clyVehicleTypeMapper;

    @Autowired
    ClyVehicleMapper clyVehicleMapper;

    public List<ClyVehicleType> getVehicleTypesByOid(int oid){
        //List<String> typeList = clyVehicleMapper.getTypesByOid(oid);
        return clyVehicleTypeMapper.getTypes(oid);
    }
}
