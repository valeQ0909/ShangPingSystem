package com.shangping.backend.service.impl.manager;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.pojo.Stock;
import com.shangping.backend.mapper.StockMapper;
import com.shangping.backend.service.manager.KucunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class KucunServiceImpl implements KucunService {

    @Autowired
    private StockMapper stockMapper;
    @Override
    public JSONObject getkucun() {
        List<Stock> list = stockMapper.selectList(null);
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();
        for(Stock stock : list){
            JSONObject item = new JSONObject();
            item.put("name", stock.getName());
            item.put("quantity", stock.getQuantity());
            item.put("price", stock.getPrice());

            // 格式化日期
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
            String strqgp = format.format(stock.getQgp());
            item.put("qgp", strqgp);
            String strpur = format.format(stock.getPurchaseTime());
            item.put("purchase_time", strpur);
            item.put("buyer", stock.getBuyer());
            item.put("supplier", stock.getSupplier());
            item.put("describe", stock.getDescribeInfo());
            item.put("unit", stock.getUnit());
            items.add(item);
        }

        resp.put("error_message", "success");
        resp.put("stocks", items);
        resp.put("stocks_count", stockMapper.selectCount(null));
        System.out.println("resp: " + resp);
        return resp;
    }
}
