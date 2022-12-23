package com.shangping.backend.controller.finance;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.service.finance.GetReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetReimbursementController {
    @Autowired
    private GetReimbursementService getReimbursementService;

    @PostMapping("/finance/getReimbursement/")
    public JSONObject caiwu(@RequestBody Map<String, String> map){
        Integer invoice_id = Integer.parseInt(map.get("invoice_id"));
        return getReimbursementService.getReimbursement(invoice_id);
    }
}
