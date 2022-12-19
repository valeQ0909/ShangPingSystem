package com.shangping.backend.controller.buyer;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.service.buyer.CaigouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaigouController {
    @Autowired
    private CaigouService caigouService;
    @GetMapping("/buyer/caigou/")
    public JSONObject getcaigou(){
        return caigouService.getcaigou();
    }
}
