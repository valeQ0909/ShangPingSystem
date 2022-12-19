package com.shangping.backend.service.manager;

import java.util.Date;
import java.util.Map;

public interface DinghuoService {
    public Map<String, String> dinghuo(String name, Integer quantity, String unit, String buyer, Date deadline);
}
