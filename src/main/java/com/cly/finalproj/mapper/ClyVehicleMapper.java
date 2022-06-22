package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyVehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyVehicleMapper {

    @Select("SELECT DISTINCT type  FROM cly_vehicle WHERE oid = #{OfficeId}")
    List<String> getTypesByOid(int OfficeId);

    @Select("SELECT * FROM cly_vehicle WHERE type = #{type} AND oid = #{OfficeId}")
    List<ClyVehicle> getVehiclesByTypeAndOid(String type, int OfficeId);

    @Select("SELECT * FROM cly_vehicle")
    List<ClyVehicle> getVehicles();

    @Select("SELECT * FROM cly_vehicle WHERE vin = #{vin}")
    ClyVehicle getVehicleById(int vin);

}
