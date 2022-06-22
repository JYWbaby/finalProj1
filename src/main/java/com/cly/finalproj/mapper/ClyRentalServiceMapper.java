package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyCustomer;
import com.cly.finalproj.entity.ClyRentalService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyRentalServiceMapper {
    @Select("SELECT * FROM cly_rental_service WHERE sevId = #{sevId}")
    ClyRentalService getRentalById(int sevId);

    @Select("SELECT * FROM cly_rental_service WHERE cid = #{cid}")
    List<ClyRentalService> getRentalByCustomer(int cid);

    @Insert("INSERT INTO cly_rental_service ( pickupDate, dropDate, startMeter, endMeter, dMeterLimit, cid, vin, oid, oid2) " +
            "VALUES( #{pickupDate}, #{dropDate}, #{startMeter}, #{endMeter}, #{dMeterLimit}, #{cid}, #{vin}, #{oid}, #{oid2})")
    @Options(useGeneratedKeys = true, keyProperty = "sevId")
    int addRentalService(ClyRentalService rentalService);

    @Select("SELECT * FROM cly_rental_service")
    List<ClyRentalService> getAllRentals();

    @Delete("DELETE FROM cly_rental_service WHERE sevId = #{sevId}")
    void deleteRental(int sevId);

    @Update("UPDATE cly_rental_service SET pickupDate = #{pickupDate}, dropDate = #{dropDate}, startMeter = #{startMeter}," +
            "endMeter = #{endMeter} WHERE sevId = #{sevId}")
    void updateRentalService(ClyRentalService rentalService);
}
