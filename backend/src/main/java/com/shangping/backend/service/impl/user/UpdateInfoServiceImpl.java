package com.shangping.backend.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangping.backend.mapper.UserMapper;
import com.shangping.backend.pojo.User;
import com.shangping.backend.service.user.UpdateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateInfoServiceImpl implements UpdateInfoService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, String> updateInfo(String username, String avatar, String nickname) {
        Map<String, String> map = new HashMap<>();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);

        User user = userMapper.selectOne(queryWrapper);
        Integer id = user.getId();
        User newuser = new User();
        newuser.setId(id);
        newuser.setPhoto(avatar);
        newuser.setNickname(nickname);
        userMapper.updateById(newuser);

        map.put("code", "200");
        map.put("error_message", "success");
        return map;
    }
}
