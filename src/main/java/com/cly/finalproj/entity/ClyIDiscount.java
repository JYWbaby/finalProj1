package com.cly.finalproj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_i_discount
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyIDiscount implements Serializable {
    /**
     * Individual discount ID
     */
    private Integer idid;

    private Date startTime;

    private Date endTime;

    /**
     * Discount number of individual discount
     */
    private BigDecimal discount;

    private Integer cid;

    private static final long serialVersionUID = 1L;
}