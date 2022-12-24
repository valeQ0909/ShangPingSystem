package com.shangping.backend.service.impl.buyer;

import com.shangping.backend.mapper.InvoiceMapper;
import com.shangping.backend.pojo.Invoice;
import com.shangping.backend.service.buyer.CaiwuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CaiwuaServiceImpl implements CaiwuaService {

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public Map<String, String> caiwu(String buyer, String billurl) {
        // 用户提交发票后，处理用户提交的发票，添加进invoice表中

        Date submit_time = new Date(); // 递交时间

        // 创建采购人员报销任务的发票记录
        Invoice invoice = new Invoice(null, billurl, submit_time, buyer, "待审核");
        // 将新创建的记录插入到invoice表中
        invoiceMapper.insert(invoice);


        Map<String, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("error_message", "success");
        return map;
    }
}
