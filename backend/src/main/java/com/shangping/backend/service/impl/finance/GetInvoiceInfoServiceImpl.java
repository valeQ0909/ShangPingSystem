package com.shangping.backend.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.shangping.backend.mapper.InvoiceMapper;
import com.shangping.backend.pojo.Invoice;
import com.shangping.backend.service.finance.GetInvoiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetInvoiceInfoServiceImpl implements GetInvoiceInfoService {
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public JSONObject getInvoiceInfo(Integer invoice_id) {
        Invoice invoice = invoiceMapper.selectById(invoice_id);
        JSONObject resp = new JSONObject();
        resp.put("invoice_id", invoice.getId());
        resp.put("invoice_bill", invoice.getInvoiceBill());
        resp.put("buyer", invoice.getBuyer());
        resp.put("state", invoice.getState());

        return resp;
    }
}
