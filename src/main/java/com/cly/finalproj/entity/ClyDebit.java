package com.cly.finalproj.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_debit
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyDebit implements Serializable {
    private Integer sevId;

    /**
     * Pin for debit payment
     */
    private Integer pin;

    private static final long serialVersionUID = 1L;
}