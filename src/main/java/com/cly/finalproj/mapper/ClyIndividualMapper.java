package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyCorp;
import com.cly.finalproj.entity.ClyIndividual;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyIndividualMapper {
    @Select("SELECT * FROM cly_individual WHERE cid = #{cid}")
    List<ClyIndividual> getIndividualById(int cid);

    @Insert("INSERT INTO cly_individual (cid, fName, lName, insComp, insNum, driveLicense) " +
            "VALUES( #{cid}, #{fName}, #{lName}, #{insComp}, #{insNum}, #{driveLicense})")
    int addIndividual(ClyIndividual individual);
}
