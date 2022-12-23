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
        Date submit_time = new Date();
        Invoice invoice = new Invoice(null, billurl, submit_time, buyer, "待审核");
        invoiceMapper.insert(invoice);
        Map<String, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("error_message", "success");
        return map;
    }
}
