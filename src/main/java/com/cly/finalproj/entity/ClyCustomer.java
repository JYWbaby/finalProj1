package com.cly.finalproj.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_customer
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyCustomer implements Serializable {
    /**
     * Unique ID of customer
     */
    private Integer cid;

    /**
     * Street of customer
     */
    private String cstreet;

    /**
     * City of customer
     */
    private String ccity;

    /**
     * State of customer
     */
    private String cstate;

    /**
     * Country of customer
     */
    private String ccountry;

    /**
     * Zipcode of customer
     */
    private String czip;

    /**
     * Email of customer
     */
    private String cemail;

    /**
     * Phone of customer
     */
    private String cphone;

    /**
     * Customer type for subtype
     */
    private String ctype;

    private static final long serialVersionUID = 1L;
}