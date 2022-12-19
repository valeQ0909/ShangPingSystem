package com.shangping.backend.pojo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shangping.backend.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
