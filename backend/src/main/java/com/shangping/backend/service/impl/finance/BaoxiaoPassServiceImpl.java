package com.shangping.backend.service.impl.finance;

import com.shangping.backend.mapper.InvoiceMapper;
import com.shangping.backend.mapper.ReimbursementMapper;
import com.shangping.backend.pojo.Invoice;
import com.shangping.backend.pojo.Reimbursement;
import com.shangping.backend.service.finance.BaoxiaoPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class BaoxiaoPassServiceImpl implements BaoxiaoPassService {
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private ReimbursementMapper reimbursementMapper;

    @Override
    public Map<String, String> baoxiaoPass(Integer invoice_id, String billurl, String staff) {
        // 这部分负责提交发票后审核通过的功能

        Map<String, String> map = new HashMap<>();

        // 增加报销记录
        Invoice invoice = invoiceMapper.selectById(invoice_id);
        Date deal_time = new Date();
        String buyer = invoice.getBuyer();
        Reimbursement reimbursement = new Reimbursement(null, billurl, deal_time, invoice_id, buyer, staff);
        reimbursementMapper.insert(reimbursement);

        // 更新采购员财务报销状态
        Invoice newinvoice = new Invoice();
        newinvoice.setId(invoice_id);
        newinvoice.setState("审核合格");
        invoiceMapper.updateById(newinvoice);

        map.put("code", "200");
        map.put("error_message", "success");
        return map;
    }
}
