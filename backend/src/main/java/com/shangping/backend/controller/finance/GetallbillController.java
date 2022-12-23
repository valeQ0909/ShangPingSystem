package com.shangping.backend.controller.finance;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.service.finance.GetallbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetallbillController {
    @Autowired
    private GetallbillService getallbillService;

    @GetMapping("/finance/getallbill/")
    public JSONObject getcaigou(){
        return getallbillService.getallbill();
    }
}
