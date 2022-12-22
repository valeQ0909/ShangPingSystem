package com.shangping.backend.controller.buyer;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.service.buyer.CaigoudetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CaigoudetailsController {
    @Autowired
    private CaigoudetailService caigoudetailService;

    @PostMapping("/buyer/caigoudetails/")
    public JSONObject caigoudetail(@RequestBody Map<String, String> map){
        Integer caigou_id = Integer.parseInt(map.get("caigou_id"));
        return caigoudetailService.caigoudetail(caigou_id);
    }
}
