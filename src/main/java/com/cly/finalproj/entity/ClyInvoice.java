package com.cly.finalproj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_invoice
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyInvoice implements Serializable {
    private Integer sevId;

    /**
     * Date of invoice generating time
     */
    private Date invoiceDate;

    /**
     * Total amount of invoice
     */
    private BigDecimal amount;

    private static final long serialVersionUID = 1L;
}