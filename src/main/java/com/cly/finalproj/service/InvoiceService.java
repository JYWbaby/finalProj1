package com.cly.finalproj.service;

import com.cly.finalproj.entity.ClyInvoice;
import com.cly.finalproj.mapper.ClyInvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    ClyInvoiceMapper clyInvoiceMapper;

    public ClyInvoice getInvoiceByService(int sevId){
        return clyInvoiceMapper.getInvoiceByService(sevId);
    }

    public void deleteInvoice(int sevId){
        clyInvoiceMapper.deleteInvoice(sevId);
    }
}
