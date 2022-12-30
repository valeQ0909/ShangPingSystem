package com.shangping.backend.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangping.backend.mapper.InvoiceMapper;
import com.shangping.backend.pojo.Invoice;
import com.shangping.backend.service.finance.GetallbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GetallbillServiceImpl implements GetallbillService {
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public JSONObject getallbill() {
        // 这部分获取所有的报销任务列表
        List<Invoice> list = invoiceMapper.selectList(null);
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();
        for(Invoice invoice: list){
            JSONObject item = new JSONObject();
            item.put("bill_id", invoice.getId());
            item.put("invoice_bill", invoice.getInvoiceBill());
            item.put("state", invoice.getState());
            items.add(item);
        }

        resp.put("code", 200);
        resp.put("error_message", "success");
        resp.put("all_bill", items);
        resp.put("bill_count", invoiceMapper.selectCount(null));
        return resp;
    }
}
