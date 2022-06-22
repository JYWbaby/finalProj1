package com.cly.finalproj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_rental_service
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyRentalService{
    /**
     * Unique service ID of rental service
     */
    private Integer sevId;

    private Date pickupDate;

    private Date dropDate;

    private BigDecimal startMeter;

    private BigDecimal endMeter;

    private BigDecimal dMeterLimit;

    private Integer cid;

    private Integer vin;

    private Integer oid;

    private Integer oid2;

}