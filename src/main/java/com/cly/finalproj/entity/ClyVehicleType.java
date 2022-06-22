package com.cly.finalproj.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_vehicle_type
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyVehicleType implements Serializable {
    /**
     * Unique type of vehicle
     */
    private String type;

    /**
     * Rental price of vehicle
     */
    private BigDecimal rental;

    /**
     * Overfee of vehicle that exceed the odometer limit
     */
    private BigDecimal overfee;

    private static final long serialVersionUID = 1L;
}