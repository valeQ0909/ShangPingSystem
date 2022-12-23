package com.shangping.backend.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangping.backend.mapper.ReimbursementMapper;
import com.shangping.backend.pojo.Reimbursement;
import com.shangping.backend.service.finance.GetReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetReimbursementServiceImpl implements GetReimbursementService {
    @Autowired
    private ReimbursementMapper reimbursementMapper;

    @Override
    public JSONObject getReimbursement(Integer invoice_id) {
        JSONObject resp = new JSONObject();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("invoice_id", invoice_id);
        Reimbursement reimbursement = reimbursementMapper.selectOne(queryWrapper);
        if(reimbursement != null) {
            String reimbursementUrl = reimbursement.getRBill();
            resp.put("code", 200);
            resp.put("reimbursementUrl", reimbursementUrl);
        }else{
            resp.put("code", 300);
            resp.put("error_message","未查找到相关报销单据");
        }


        return resp;
    }
}
