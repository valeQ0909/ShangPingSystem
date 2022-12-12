package com.shangping.backend.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangping.backend.mapper.UserMapper;
import com.shangping.backend.pojo.User;
import com.shangping.backend.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedpassword, String identity) {
        Map<String, String> map = new HashMap<>();

        if (username == null) {
            map.put("error_message", "用户名不能为空");
            System.out.println("1111");
            return map;
        }

        if (password == null || confirmedpassword == null){
            map.put("error_message", "密码不能为空");
            return map;
        }

        username = username.trim();
        if (username.length() == 0){
            map.put("error_message", "用户名不能为空");
            System.out.println("2222");
            return map;
        }

        if (password.length() == 0 || confirmedpassword.length() == 0){
            map.put("error_message", "密码不能为空");
            return map;
        }

        if (username.length() > 20){
            map.put("error_message", "用户名长度不能大于20");
            return map;
        }
        if(password.length() > 10 ||confirmedpassword.length() > 10){
            map.put("error_message", "密码长度不能大于10");
            return map;
        }

        if (!password.equals(confirmedpassword)){
            map.put("error_message", "两次输入的密码不一致");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty()){
            map.put("error_message", "用户名已存在");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/81680_lg_6a90272086.jpg";
        String nickname = "用户" + username.toString();
        User user = new User(null,username, nickname, encodedPassword, identity, photo);
        userMapper.insert(user);
        map.put("code", "200");
        map.put("error_message", "success");
        return map;
    }
}