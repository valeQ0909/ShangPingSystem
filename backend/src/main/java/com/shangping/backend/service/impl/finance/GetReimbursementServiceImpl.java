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
        // 这部分查询具体的报销单据的信息

        JSONObject resp = new JSONObject();

        // 根据发票id在报销单据表中查询相应的报销单据
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("invoice_id", invoice_id);
        Reimbursement reimbursement = reimbursementMapper.selectOne(queryWrapper);

        if(reimbursement != null) { // 如果查到了，返回具体报销单据的图片链接
            String reimbursementUrl = reimbursement.getRBill();
            resp.put("code", 200);
            resp.put("reimbursementUrl", reimbursementUrl);
        }else{ // 如果没查到，返回报错状态码，并返回报错信息
            resp.put("code", 300);
            resp.put("error_message","未查找到相关报销单据");
        }


        return resp;
    }
}
