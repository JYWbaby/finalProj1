package com.cly.finalproj.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_office
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyOffice implements Serializable {
    /**
     * Unique ID of office
     */
    private Integer oid;

    /**
     * Name of office
     */
    private String oname;

    /**
     * Street of office
     */
    private String ostreet;

    /**
     * City of office
     */
    private String ocity;

    /**
     * State of office
     */
    private String ostate;

    /**
     * Zipcode of office
     */
    private String ozip;

    /**
     * Phone number of office
     */
    private String ophone;

    private static final long serialVersionUID = 1L;
}