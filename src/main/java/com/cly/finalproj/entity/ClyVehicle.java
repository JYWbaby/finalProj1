package com.cly.finalproj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * cly_vehicle
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyVehicle implements Serializable {
    /**
     * Unique VIN of vehicle
     */
    private Integer vin;

    /**
     * Manufacturer of vehicle
     */
    private String make;

    /**
     * Model of vehicle
     */
    private String model;

    /**
     * Released year of vehicle
     */
    private Date year;

    private String plate;

    private Integer oid;

    private String type;

    private static final long serialVersionUID = 1L;
}