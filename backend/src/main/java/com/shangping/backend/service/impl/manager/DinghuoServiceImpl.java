package com.shangping.backend.service.impl.manager;

import com.shangping.backend.pojo.Dinghuo;
import com.shangping.backend.mapper.DinghuoMapper;
import com.shangping.backend.service.manager.DinghuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class DinghuoServiceImpl implements DinghuoService {
    @Autowired
    private DinghuoMapper dinghuoMapper;
    @Override
    public Map<String, String> dinghuo(String name, Integer quantity, String unit, String buyer, Date deadline) {
        Map<String, String> map = new HashMap<>();

        Date now = new Date();// 获取当前时间
        // 创建新的dinghuo记录
        Dinghuo dinghuo = new Dinghuo(null,now, name, quantity, deadline,buyer,unit, "待采购");
        // 将该记录插入数据库中
        dinghuoMapper.insert(dinghuo);

        map.put("code", "200");
        map.put("error_message", "success");
        return map;
    }
}
