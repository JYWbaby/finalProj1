package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyCustomer;
import com.cly.finalproj.entity.ClyPayment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyCustomerMapper {
    @Select("SELECT * FROM cly_customer WHERE cid = #{cid}")
    List<ClyCustomer> getCustomerById(int cid);

    @Insert("INSERT INTO cly_customer ( cstreet, ccity, cstate, ccountry, czip, cemail, cphone, ctype) " +
            "VALUES( #{cstreet}, #{ccity}, #{cstate}, #{ccountry}, #{czip}, #{cemail}, #{cphone}, #{ctype})")
    @Options(useGeneratedKeys = true, keyProperty = "cid")
    int addCustomer(ClyCustomer customer);
}
