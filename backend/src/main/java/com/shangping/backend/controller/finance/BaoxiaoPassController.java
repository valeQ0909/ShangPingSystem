package com.shangping.backend.controller.finance;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.service.finance.BaoxiaoPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BaoxiaoPassController {
    @Autowired
    private BaoxiaoPassService baoxiaoPassService;

    @PostMapping("/finance/baoxiaoPass/")
    public Map<String, String> caiwu(@RequestBody Map<String, String> map){
        String billurl = map.get("billurl");
        Integer invoice_id = Integer.parseInt(map.get("invoice_id"));
        String staff = map.get("staff");
        return baoxiaoPassService.baoxiaoPass(invoice_id, billurl, staff);
    }
}
