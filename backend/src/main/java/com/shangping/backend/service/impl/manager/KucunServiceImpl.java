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
        //需要返回给前端的总Json对象
        JSONObject resp = new JSONObject();

        // 创建一个Json列表，用于包装需要返回的所有库存信息
        List<JSONObject> items = new LinkedList<>();

        // 在数据库内查询所有库存信息，返回一个列表
        List<Stock> list = stockMapper.selectList(null);

        // 循环列表内的每一条库存记录，取出具体值，先包裹成item，再添加到items中
        for(Stock stock : list){
            // 创建Json对象item存储当前一条的库存记录信息
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

            // 最后将当前的item添加到总的items中
            items.add(item);
        }

        resp.put("error_message", "success");
        resp.put("stocks", items);
        resp.put("stocks_count", stockMapper.selectCount(null));
        System.out.println("resp: " + resp);
        return resp;
    }
}
