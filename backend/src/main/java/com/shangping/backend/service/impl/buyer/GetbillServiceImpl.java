package com.shangping.backend.service.impl.buyer;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangping.backend.mapper.InvoiceMapper;
import com.shangping.backend.pojo.Invoice;
import com.shangping.backend.service.buyer.GetbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GetbillServiceImpl implements GetbillService {
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public JSONObject getbill(String buyer) {
        // 在采购人员的报销功能页面上，展示所有和他相关的报销任务的列表

        // 在invoice表中根据该采购人员的账号查询所有和他有关的记录
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("buyer", buyer);
        List<Invoice> list = invoiceMapper.selectList(queryWrapper);
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();

        // 取出每一条记录进行处理，加工成Json对象
        for(Invoice invoice: list){
            JSONObject item = new JSONObject();
            item.put("bill_id", invoice.getId());
            item.put("invoice_bill", invoice.getInvoiceBill());
            item.put("state", invoice.getState());
            items.add(item);
        }

        resp.put("code", 200);
        resp.put("error_message", "success");
        resp.put("bill", items);
        resp.put("bill_count", invoiceMapper.selectCount(queryWrapper));

        return resp;
    }
}
