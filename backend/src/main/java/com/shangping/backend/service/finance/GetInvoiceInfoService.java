package com.shangping.backend.service.finance;

import com.alibaba.fastjson.JSONObject;

public interface GetInvoiceInfoService {
    public JSONObject getInvoiceInfo(Integer invoice_id);
}
