package com.shangping.backend.controller.user;

import com.shangping.backend.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/user/register/")
    public Map<String, String> register(@RequestBody Map<String, String> map){

        System.out.println("map: " + map);

        String username = map.get("username");
        String password = map.get("password");
        String confirmedPassword = map.get("confirmedPassword");
        String identity = map.get("identity");

        return registerService.register(username, password, confirmedPassword, identity);
    }
}

