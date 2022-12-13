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

        // 用户名为空，报错
        if (username == null) {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        // 密码或确认密码为空，报错
        if (password == null || confirmedpassword == null){
            map.put("error_message", "密码不能为空");
            return map;
        }

        // trim函数处理掉账号内的空格，防止账号全为空格
        username = username.trim();
        if (username.length() == 0){
            map.put("error_message", "用户名不能为空");
            System.out.println("2222");
            return map;
        }

        // 密码不能为空
        if (password.length() == 0 || confirmedpassword.length() == 0){
            map.put("error_message", "密码不能为空");
            return map;
        }

        // 账号长度不能大于20
        if (username.length() > 20){
            map.put("error_message", "用户名长度不能大于20");
            return map;
        }

        // 密码长度不能大于10
        if(password.length() > 10 ||confirmedpassword.length() > 10){
            map.put("error_message", "密码长度不能大于10");
            return map;
        }

        // 如果密码和确认密码相不相同，则报错
        if (!password.equals(confirmedpassword)){
            map.put("error_message", "两次输入的密码不一致");
            return map;
        }

        // 通过maybaitsplus查询账号是否存在，若已存在则报错
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty()){
            map.put("error_message", "用户名已存在");
            return map;
        }

        //将明文密码进行md5(md5是一种不可逆的加密算法)加密，保护用户的隐私安全
        String encodedPassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/81680_lg_6a90272086.jpg";
        String nickname = "用户" + username;

        // 创建新用户，并添加至数据库
        User user = new User(null, username, nickname, encodedPassword, identity, photo);
        userMapper.insert(user);
        map.put("code", "200");
        map.put("error_message", "success");

        //返回信息至前端
        return map;
    }
}