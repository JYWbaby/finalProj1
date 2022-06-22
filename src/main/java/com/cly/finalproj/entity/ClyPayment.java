package com.cly.finalproj.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_payment
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyPayment implements Serializable {
    private Integer sevId;

    /**
     * Payment date
     */
    private Date payDate;

    private String cardNum;

    /**
     * Method of payment for subtype
     */
    private String method;

    private static final long serialVersionUID = 1L;
}