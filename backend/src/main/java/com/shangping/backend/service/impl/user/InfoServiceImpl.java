package com.shangping.backend.service.impl.user;

import com.shangping.backend.pojo.User;
import com.shangping.backend.service.impl.utils.UserDetailsImpl;
import com.shangping.backend.service.user.InfoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public Map<String, String> getinfo() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("username", user.getUsername());
        map.put("nickname", user.getNickname());
        map.put("photo", user.getPhoto());
        map.put("identity", user.getIdentity());
        return map;

    }
}
