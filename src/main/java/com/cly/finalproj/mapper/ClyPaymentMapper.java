package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyOffice;
import com.cly.finalproj.entity.ClyPayment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyPaymentMapper {

    @Select("SELECT * FROM cly_payment WHERE sevId = #{sev_id}")
    ClyPayment getPaymentBySevId(int sev_id);

    @Insert("INSERT INTO cly_payment (sevId, payDate, cardNum, method) VALUES(#{sevId}, #{payDate}, #{cardNum}, #{method})")
    int addPayment(ClyPayment payment);

    @Delete("DELETE FROM cly_payment WHERE sevId = #{sevId}")
    void deletePayment(int sevId);

}
