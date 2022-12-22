package com.shangping.backend.service.impl.buyer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangping.backend.pojo.Dinghuo;
import com.shangping.backend.pojo.Stock;
import com.shangping.backend.pojo.mapper.DinghuoMapper;
import com.shangping.backend.pojo.mapper.StockMapper;
import com.shangping.backend.service.buyer.CaigoufinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CaigoufinishServiceImpl implements CaigoufinishService {
    @Autowired
    private DinghuoMapper dinghuoMapper;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public Map<String, String> caigoufinsih(Integer caigou_id, Integer price, String supplier, Date qgp, String desccribe_info) {
        Dinghuo dinghuo = dinghuoMapper.selectById(caigou_id);
        String goods_name = dinghuo.getGoodsName();
        Integer quantity = dinghuo.getQuantity();
        Date purchase_time = new Date();
        String buyer = dinghuo.getBuyer();
        String unit = dinghuo.getUnit();

        QueryWrapper<Stock> querywrapper = new QueryWrapper<Stock>();
        querywrapper.eq("name", goods_name);

        // 更新库存
        Stock stock = stockMapper.selectOne(querywrapper);
        if(stock != null){  //如果库存内有该物品
            System.out.println("stock != null: "+stock);
            Integer past_quantity = stock.getQuantity();
            quantity = past_quantity + quantity;
            Stock nestock = new Stock();
            nestock.setId(stock.getId());
            nestock.setQuantity(quantity);
            stockMapper.updateById(nestock);
        }else{ //如果库存内无改物品
            System.out.println("stock == null :"+stock);
            Stock newstock = new Stock(null, goods_name, quantity, price, qgp, purchase_time, buyer, supplier,desccribe_info, unit);
            stockMapper.insert(newstock);
        }

        // 更新采购订单状态
        Dinghuo newdinghuo = new Dinghuo();
        newdinghuo.setId(caigou_id);
        newdinghuo.setState("完成采购");
        dinghuoMapper.updateById(newdinghuo);

        Map<String, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("error_message", "success");
        return map;
    }
}
