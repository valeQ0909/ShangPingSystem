package com.shangping.backend.service.user;

import java.util.Map;

public interface UpdateInfoService {
    public Map<String, String> updateInfo(String username, String avatar, String nickname);
}
