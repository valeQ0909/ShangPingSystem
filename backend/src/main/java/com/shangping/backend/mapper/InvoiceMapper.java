package com.shangping.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shangping.backend.pojo.Invoice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {
}
