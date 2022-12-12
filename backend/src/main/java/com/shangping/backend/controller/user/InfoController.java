package com.shangping.backend.controller.user;

import com.shangping.backend.service.user.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/user/info/")
    public Map<String, String> getinfo(){
        return infoService.getinfo();
    }
}
