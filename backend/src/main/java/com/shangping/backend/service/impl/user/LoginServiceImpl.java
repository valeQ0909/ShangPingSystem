package com.shangping.backend.service.impl.user;

import com.shangping.backend.pojo.User;
import com.shangping.backend.service.impl.utils.UserDetailsImpl;
import com.shangping.backend.service.user.LoginService;
import com.shangping.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, String> getToken(String username, String password){
        //通过security库的固定写法，在数据库内校验账号和密码是否正确
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken); //登录失败会自动处理

        //框架固定写法创建user对象，返回数据库内相应账号的信息
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        User user = loginUser.getUser();

        // 创建jwt令牌（jwt的配置由钱宸组长负责），jwt令牌将存放在用户浏览器的localstorage内，用来确认用户是否登录
        String jwt = JwtUtil.createJWT(user.getUsername());
        // 通过Map存储将要返回的信息
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");  //将成功的信息返回给前端
        map.put("token", jwt);  //将令牌返回给前端

        //将信息返回给前端
        return map;
    }

}
