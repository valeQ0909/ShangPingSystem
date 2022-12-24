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

        // 创建mybitasplus的querywrapper用于查询
        QueryWrapper queryWrapper = new QueryWrapper<>();
        // 查询条件是用户账号相同
        queryWrapper.eq("username", username);

        // 在数据库内查询该账号所对应的用户
        User user = userMapper.selectOne(queryWrapper);

        // 获取该用户的id
        Integer id = user.getId();
        // 创建新的记录，Mapper可以通过该记录去数据库内找到原来的记录并修改原来的记录内容
        User newuser = new User();
        // 设置新记录的id、头像地址、用户名
        newuser.setId(id);
        newuser.setPhoto(avatar);
        newuser.setNickname(nickname);

        // 更新数据库内该用户的信息（新头像，新昵称）
        userMapper.updateById(newuser);

        map.put("code", "200");
        map.put("error_message", "success");
        return map;
    }
}
