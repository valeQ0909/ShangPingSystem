package com.shangping.backend.service.impl.buyer;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangping.backend.pojo.Dinghuo;
import com.shangping.backend.mapper.DinghuoMapper;
import com.shangping.backend.pojo.User;
import com.shangping.backend.service.buyer.CaigouService;
import com.shangping.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
        // 采购员在采购任务页面展示所有和他有关的采购任务功能

        // 通过token令牌获取该采购员的username
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();
        String buyer = user.getUsername();

        // 创建查询条件
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("buyer", buyer);

        // 在dinghuo表中查询所有和该采购员有关的记录
        List<Dinghuo> list = dinghuoMapper.selectList(queryWrapper);
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

        resp.put("error_message", "success");
        resp.put("caigou", items);
        resp.put("caigou_count", dinghuoMapper.selectCount(queryWrapper));
        return resp;
    }
}
