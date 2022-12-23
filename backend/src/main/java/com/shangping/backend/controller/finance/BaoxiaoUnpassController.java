package com.shangping.backend.controller.finance;

import com.shangping.backend.service.finance.BaoxiaoUnpassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BaoxiaoUnpassController {
    @Autowired
    private BaoxiaoUnpassService baoxiaoUnpassService;

    @PostMapping("/finance/baoxiaoUnpass/")
    public Map<String, String> caiwu(@RequestBody Map<String, String> map){
        Integer invoice_id = Integer.parseInt(map.get("invoice_id"));
        return baoxiaoUnpassService.baoxiaoUnpass(invoice_id);
    }
}
