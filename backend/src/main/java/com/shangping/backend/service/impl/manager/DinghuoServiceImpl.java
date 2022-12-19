package com.shangping.backend.service.impl.manager;

import com.shangping.backend.service.manager.DinghuoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class DinghuoServiceImpl implements DinghuoService {
    @Override
    public Map<String, String> dinghuo(String name, Integer quantity, Date deadline, String buyer, String unit) {

        Map<String, String> map = new HashMap<>();
        return map;
    }
}
