package com.example.springapp1.services;

import com.example.springapp1.model.dto.UserThinDto;
import com.example.springapp1.model.web.LoginParams;

public interface AuthorizationService {

    UserThinDto login(LoginParams loginParams);

    void logout(String sessionId);
}
