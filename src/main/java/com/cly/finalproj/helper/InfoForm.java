package com.cly.finalproj.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoForm {
    private String street;
    private String city;
    private String state;
    private String Country;
    private String zip;
    private String email;
    private String phone;

    private String corpName;
    private String regNum;
    private String empId;

    private String fname;
    private String lname;
    private String insComp;
    private String insNum;
    private String driveLicense;

}
