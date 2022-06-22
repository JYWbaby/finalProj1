package com.cly.finalproj.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_credit
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyCredit implements Serializable {
    private Integer sevId;

    /**
     * CVV code for credit payment
     */
    private Short cvv;

    /**
     * Valid date of credit card
     */
    private String validDate;

    private static final long serialVersionUID = 1L;
}