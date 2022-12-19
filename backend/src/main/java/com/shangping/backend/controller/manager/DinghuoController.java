package com.shangping.backend.controller.manager;

import com.shangping.backend.service.manager.DinghuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class DinghuoController {
    @Autowired
    private DinghuoService dinghuoService;

    @PostMapping("/manager/dinghuo/")
    public Map<String, String> register(@RequestBody Map<String, String> map){
        String name = map.get("name");
        Integer quantity = Integer.parseInt(map.get("quantity"));
        String unit = map.get("unit");
        String buyer = map.get("buyer");
        String deadline = map.get("deadline");

        //时间格式字符串  "2020-02-13 16:01:30"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(deadline);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dinghuoService.dinghuo(name, quantity, unit, buyer,date);
    }

}
