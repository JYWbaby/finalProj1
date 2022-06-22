package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyCorp;
import com.cly.finalproj.entity.ClyCustomer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyCorpMapper {
    @Select("SELECT * FROM cly_corp WHERE cid = #{cid}")
    List<ClyCorp> getCorprById(int cid);

    @Insert("INSERT INTO cly_corp (cid, corpName, regNum, empId) " +
            "VALUES( #{cid}, #{corpName}, #{regNum}, #{empId})")
    int addCorp(ClyCorp corp);
}
