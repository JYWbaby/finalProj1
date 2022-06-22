package com.cly.finalproj.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_corp
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyCorp implements Serializable {
    /**
     * Unique ID of customer
     */
    private Integer cid;

    /**
     * The name of corporation 
     */
    private String corpName;

    /**
     * Registration number of the corporation
     */
    private String regNum;

    /**
     * Employee ID of the customer who rents the car on a corporate account
     */
    private String empId;

    private static final long serialVersionUID = 1L;
}