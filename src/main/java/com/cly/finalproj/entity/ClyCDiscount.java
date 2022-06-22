package com.cly.finalproj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyCDiscount implements Serializable {
    /**
     * Corporation discount ID
     */
    private Integer cdid;

    /**
     * Corporation discount number
     */
    private BigDecimal discount;

    private Integer cid;
}
