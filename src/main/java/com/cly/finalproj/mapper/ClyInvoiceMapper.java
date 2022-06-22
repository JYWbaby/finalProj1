package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.ClyInvoice;
import com.cly.finalproj.entity.ClyRentalService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClyInvoiceMapper {
    @Select("SELECT * FROM cly_invoice WHERE sevId = #{sevId}")
    ClyInvoice getInvoiceByService(int sevId);

    @Delete("DELETE FROM cly_invoice WHERE sevId = #{sevId}")
    void deleteInvoice(int sevId);
}
