package com.cly.finalproj.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyForm {
    private String startDate;
    private String endDate;
    private String startMeter;
    private String endMeter;
}
