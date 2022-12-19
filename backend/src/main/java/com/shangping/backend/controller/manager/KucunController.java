package com.shangping.backend.controller.manager;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.service.manager.KucunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KucunController {
    @Autowired
    private KucunService kucunService;

    @GetMapping("/manager/kucun/")
    public JSONObject getkucun(){
        return kucunService.getkucun();
    }
}
