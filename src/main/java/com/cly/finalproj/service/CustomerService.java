package com.cly.finalproj.service;

import com.cly.finalproj.entity.ClyCorp;
import com.cly.finalproj.entity.ClyCustomer;
import com.cly.finalproj.entity.ClyIndividual;
import com.cly.finalproj.mapper.ClyCorpMapper;
import com.cly.finalproj.mapper.ClyCustomerMapper;
import com.cly.finalproj.mapper.ClyIndividualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    ClyCustomerMapper clyCustomerMapper;
    @Autowired
    ClyIndividualMapper clyIndividualMapper;
    @Autowired
    ClyCorpMapper clyCorpMapper;

    public int insertCustomer(ClyCustomer customer){
        return clyCustomerMapper.addCustomer(customer);
    }

    public int insertCorp(ClyCorp corp){
        return clyCorpMapper.addCorp(corp);
    }

    public int insertIndividual(ClyIndividual individual){
        return clyIndividualMapper.addIndividual(individual);
    }
}
