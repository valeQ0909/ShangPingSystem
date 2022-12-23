package com.shangping.backend.controller.buyer;

import com.shangping.backend.service.buyer.CaiwuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CaiwuaController {
    @Autowired
    private CaiwuaService caiwuaService;
    @PostMapping("/buyer/caiwu/")
    public Map<String, String> caiwu(@RequestBody Map<String, String> map){
        String billurl = map.get("billurl");
        String buyer = map.get("buyer");

        return caiwuaService.caiwu(buyer, billurl);
    }

}
