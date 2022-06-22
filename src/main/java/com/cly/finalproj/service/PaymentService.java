package com.cly.finalproj.service;

import com.cly.finalproj.entity.ClyCredit;
import com.cly.finalproj.entity.ClyDebit;
import com.cly.finalproj.entity.ClyPayment;
import com.cly.finalproj.entity.ClyRentalService;
import com.cly.finalproj.mapper.ClyCreditMapper;
import com.cly.finalproj.mapper.ClyDebitMapper;
import com.cly.finalproj.mapper.ClyPaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    ClyPaymentMapper clyPaymentMapper;

    @Autowired
    ClyDebitMapper clyDebitMapper;

    @Autowired
    ClyCreditMapper clyCreditMapper;

    public int addPayment(ClyPayment payment){
        return clyPaymentMapper.addPayment(payment);
    }

    public int addDebit(ClyDebit debit){
        return clyDebitMapper.addDebit(debit);
    }

    public int addCredit(ClyCredit credit){
        return clyCreditMapper.addCredit(credit);
    }

    public void deletePayment(int sevId){
        ClyPayment payment = clyPaymentMapper.getPaymentBySevId(sevId);
        String type = payment.getMethod();
        if(type.equals("C"))
            clyCreditMapper.deleteCredit(sevId);
        if(type.equals("D"))
            clyDebitMapper.deleteDebit(sevId);

        clyPaymentMapper.deletePayment(sevId);


    }
}
