package com.shangping.backend.service.user;

import java.util.Map;

public interface RegisterService {

    public Map<String, String> register(String username, String password, String confirmedpassword, String indentity);
}
