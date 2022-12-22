package com.shangping.backend.controller.buyer;

import com.shangping.backend.service.buyer.CaigoufinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class CaigoufinishController {
    @Autowired
    private CaigoufinishService caigoufinishService;

    @PostMapping("/buyer/caigoufinish/")
    public Map<String, String> register(@RequestBody Map<String, String> map){
        Integer caigou_id = Integer.parseInt(map.get("caigou_id"));
        Integer price = Integer.parseInt(map.get("price"));
        String supplier = map.get("supplier");
        String describe_info = map.get("describe_info");

        String qgp = map.get("qgp");

        //时间格式字符串  "2020-02-13 16:01:30"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(qgp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return caigoufinishService.caigoufinsih(caigou_id, price,supplier,date,describe_info);
    }
}
