package com.shangping.backend.service.buyer;

import java.util.Date;
import java.util.Map;

public interface CaigoufinishService {
    public Map<String, String> caigoufinsih(Integer caigou_id, Integer price, String supplier, Date qgp, String desccribe_info);
}
