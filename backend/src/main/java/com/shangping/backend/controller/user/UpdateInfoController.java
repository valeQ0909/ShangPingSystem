package com.shangping.backend.controller.user;

import com.shangping.backend.service.user.UpdateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateInfoController {
    @Autowired
    private UpdateInfoService updateInfoService;

    @PostMapping("/user/updateInfo/")
    public Map<String, String> register(@RequestBody Map<String, String> map){
        String username = map.get("username");
        String avatar = map.get("avatar");
        String nickname = map.get("nickname");

        return updateInfoService.updateInfo(username, avatar,nickname);
    }
}
