package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyCredit;
import com.cly.finalproj.entity.ClyDebit;
import com.cly.finalproj.entity.ClyPayment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyCreditMapper {
    @Insert("INSERT INTO cly_credit (sevId, cvv, validDate) VALUES(#{sevId}, #{cvv}, #{validDate})")
    int addCredit(ClyCredit clyCredit);

    @Select("SELECT * FROM cly_credit WHERE sevId = #{sevId}")
    List<ClyCredit> getCreditBySevId(int sevId);

    @Delete("DELETE FROM cly_credit WHERE sevId = #{sevId}")
    void deleteCredit(int sevId);
}
