package com.cly.finalproj.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_individual
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyIndividual implements Serializable {
    /**
     * Unique ID of customer
     */
    private Integer cid;

    /**
     * First name of customer
     */
    private String fName;

    /**
     * Last name of customer
     */
    private String lName;

    /**
     * Insurance Company Name
     */
    private String insComp;

    /**
     * Insurance Policy Number
     */
    private String insNum;

    /**
     * Drive license of customer
     */
    private String driveLicense;

    private static final long serialVersionUID = 1L;
}