package com.shangping.backend.controller.buyer;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.service.buyer.GetbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetbillController {
    @Autowired
    private GetbillService getbillService;

    @PostMapping("/buyer/getbill/")
    public JSONObject getbill(@RequestBody Map<String, String> map){
        String buyer = map.get("buyer");
        return getbillService.getbill(buyer);
    }
}
