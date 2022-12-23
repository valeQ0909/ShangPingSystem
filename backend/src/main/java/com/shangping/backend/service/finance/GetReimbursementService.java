package com.shangping.backend.service.finance;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface GetReimbursementService {
    public JSONObject getReimbursement(Integer invoice_id);
}
