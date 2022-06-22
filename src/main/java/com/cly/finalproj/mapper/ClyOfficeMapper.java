package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyOffice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyOfficeMapper {

    @Select("SELECT * FROM cly_office WHERE oid = #{OfficeId}")
    ClyOffice getOfficeById(int OfficeId);

    @Select("SELECT * FROM cly_office")
    List<ClyOffice> getAllOffice();

}
