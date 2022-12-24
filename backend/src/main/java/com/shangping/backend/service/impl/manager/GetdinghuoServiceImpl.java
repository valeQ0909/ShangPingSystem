package com.shangping.backend.service.impl.manager;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.mapper.DinghuoMapper;
import com.shangping.backend.pojo.Dinghuo;
import com.shangping.backend.service.manager.GetdinghuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class GetdinghuoServiceImpl implements GetdinghuoService {
    @Autowired
    private DinghuoMapper dinghuoMapper;

    @Override
    public JSONObject getdinghuo() {

        // 在dinghuo表中查询所有记录
        List<Dinghuo> list = dinghuoMapper.selectList(null);
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();
        // 取出每一条记录，进行加工
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

        resp.put("code", 200);
        resp.put("error_message", "success");
        resp.put("dinghuo", items);
        resp.put("dinghuo_count", dinghuoMapper.selectCount(null));
        return resp;
    }
}
