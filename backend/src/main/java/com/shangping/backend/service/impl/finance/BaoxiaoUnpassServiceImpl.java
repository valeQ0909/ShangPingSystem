package com.shangping.backend.service.impl.finance;

import com.shangping.backend.mapper.InvoiceMapper;
import com.shangping.backend.pojo.Invoice;
import com.shangping.backend.service.finance.BaoxiaoUnpassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BaoxiaoUnpassServiceImpl implements BaoxiaoUnpassService {
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public Map<String, String> baoxiaoUnpass(Integer invoice_id) {
        Map<String, String> map = new HashMap<>();

        // 修改采购人员财务报销状态未审核不合格
        Invoice newinvoice = new Invoice();
        newinvoice.setId(invoice_id);
        newinvoice.setState("审核不合格");
        invoiceMapper.updateById(newinvoice);

        map.put("code", "200");
        map.put("error_message", "success");
        return map;
    }
}
