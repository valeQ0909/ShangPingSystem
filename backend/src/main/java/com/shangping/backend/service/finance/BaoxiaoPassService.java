package com.shangping.backend.service.finance;

import java.util.Map;

public interface BaoxiaoPassService {
    public Map<String, String> baoxiaoPass(Integer invoice_id, String billurl, String staff);
}
