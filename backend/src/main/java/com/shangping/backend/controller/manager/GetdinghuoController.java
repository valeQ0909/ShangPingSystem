package com.shangping.backend.controller.manager;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.service.manager.GetdinghuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetdinghuoController {
    @Autowired
    private GetdinghuoService getdinghuoService;

    @GetMapping("/manager/getDinghuo/")
    public JSONObject getkucun(){
        return getdinghuoService.getdinghuo();
    }
}
