package com.cly.finalproj.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cly_gift_card
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClyGiftCard implements Serializable {
    private Integer sevId;

    private static final long serialVersionUID = 1L;
}