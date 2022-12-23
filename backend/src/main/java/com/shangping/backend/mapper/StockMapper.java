package com.shangping.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shangping.backend.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockMapper extends BaseMapper<Stock> {
}
