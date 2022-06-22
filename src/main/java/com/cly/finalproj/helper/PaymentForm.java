package com.cly.finalproj.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentForm {
    private String cardNumber;
    private String pin;
    private String cvv;
    private String validDate;


}
