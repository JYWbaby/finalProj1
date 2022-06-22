package com.cly.finalproj.mapper;

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
public interface ClyDebitMapper {

    @Insert("INSERT INTO cly_debit (sevId, pin) VALUES(#{sevId}, #{pin})")
    int addDebit(ClyDebit clyDebit);

    @Select("SELECT * FROM cly_debit WHERE sevId = #{sev_id}")
    List<ClyDebit> getDebitBySevId(int sev_id);

    @Delete("DELETE FROM cly_debit WHERE sevId = #{sevId}")
    void deleteDebit(int sevId);
}
