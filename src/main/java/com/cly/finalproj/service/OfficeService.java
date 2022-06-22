package com.cly.finalproj.service;

import com.cly.finalproj.entity.ClyOffice;
import com.cly.finalproj.mapper.ClyOfficeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {

    @Autowired
    ClyOfficeMapper clyOfficeMapper;

    public List<ClyOffice> getAllOffice(){
        return clyOfficeMapper.getAllOffice();
    }

    public ClyOffice getOfficeById(int oid){
        return clyOfficeMapper.getOfficeById(oid);
    }
}
