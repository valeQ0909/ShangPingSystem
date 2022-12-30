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
        // 这部分获取具体的发票信息

        // 根据传递进来的发票id进行详细查询
        Invoice invoice = invoiceMapper.selectById(invoice_id);
        // 包装查询到的数据并返回给前端
        JSONObject resp = new JSONObject();
        resp.put("invoice_id", invoice.getId());
        resp.put("invoice_bill", invoice.getInvoiceBill());
        resp.put("buyer", invoice.getBuyer());
        resp.put("state", invoice.getState());

        return resp;
    }
}
