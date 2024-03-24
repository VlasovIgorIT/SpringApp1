package com.example.springapp1.services;

import com.example.springapp1.models.dto.UserThinDto;
import com.example.springapp1.models.web.LoginParams;

public interface AuthorizationService {

    UserThinDto login(LoginParams loginParams);

    void logout(String sessionId);
}
