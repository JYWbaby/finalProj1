package com.cly.finalproj.helper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RentHelper {
    private Integer pickOffice;
    private Integer vin;

    private Integer dropLocation;

    private Integer sevId;


    public Integer getPickOffice() {
        return pickOffice;
    }

    public void setPickOffice(Integer pickOffice) {
        this.pickOffice = pickOffice;
    }

    public Integer getVin() {
        return vin;
    }

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    public Integer getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Integer dropLocation) {
        this.dropLocation = dropLocation;
    }

    public Integer getSevId() {
        return sevId;
    }

    public void setSevId(Integer sevId) {
        this.sevId = sevId;
    }
}
