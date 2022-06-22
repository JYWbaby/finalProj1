package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyVehicleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyVehicleTypeMapper {

    @Select("SELECT * FROM cly_vehicle_type WHERE type in (SELECT DISTINCT type FROM cly_vehicle WHERE oid = #{OfficeId})")
    List<ClyVehicleType> getTypes(int oid);

}
