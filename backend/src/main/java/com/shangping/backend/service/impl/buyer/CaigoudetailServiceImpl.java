package com.shangping.backend.service.impl.buyer;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.pojo.Dinghuo;
import com.shangping.backend.mapper.DinghuoMapper;
import com.shangping.backend.service.buyer.CaigoudetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class CaigoudetailServiceImpl implements CaigoudetailService {
    @Autowired
    private DinghuoMapper dinghuoMapper;

    @Override
    public JSONObject caigoudetail(Integer caigou_id) {

        // 在dinghuo数据表内查询该订货记录，并返回该记录所对应的所有信息
        Dinghuo dinghuo = dinghuoMapper.selectById(caigou_id);
        JSONObject resp = new JSONObject();
        resp.put("buyer", dinghuo.getBuyer());
        resp.put("quantity", dinghuo.getQuantity());
        resp.put("goods_name", dinghuo.getGoodsName());
        resp.put("state", dinghuo.getState());
        resp.put("unit", dinghuo.getUnit());
        resp.put("caigou_id",dinghuo.getId());

        // 格式化日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strdeltime = format.format(dinghuo.getDeliveryTime());
        resp.put("delivery_time", strdeltime);
        String strddl = format.format(dinghuo.getDeadline());
        resp.put("deadline", strddl);

        return resp;
    }
}
