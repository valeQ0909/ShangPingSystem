package com.shangping.backend.service.impl.buyer;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.pojo.Dinghuo;
import com.shangping.backend.pojo.mapper.DinghuoMapper;
import com.shangping.backend.service.buyer.CaigouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class CaigouServiceImpl implements CaigouService {
    @Autowired
    private DinghuoMapper dinghuoMapper;

    @Override
    public JSONObject getcaigou() {
        List<Dinghuo> list = dinghuoMapper.selectList(null);
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();
        for(Dinghuo dinghuo : list){
            JSONObject item = new JSONObject();
            item.put("buyer", dinghuo.getBuyer());
            item.put("quantity", dinghuo.getQuantity());
            item.put("goods_name", dinghuo.getGoodsName());
            item.put("state", dinghuo.getState());
            item.put("unit", dinghuo.getUnit());
            item.put("caigou_id",dinghuo.getId());

            // 格式化日期
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strdeltime = format.format(dinghuo.getDeliveryTime());
            item.put("delivery_time", strdeltime);
            String strddl = format.format(dinghuo.getDeadline());
            item.put("deadline", strddl);

            items.add(item);
        }

        resp.put("error_message", "success");
        resp.put("caigou", items);
        resp.put("caigou_count", dinghuoMapper.selectCount(null));
        System.out.println("caigou: " + resp);
        return resp;
    }
}
