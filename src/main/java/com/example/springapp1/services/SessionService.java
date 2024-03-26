package com.example.springapp1.services;

import com.example.springapp1.model.dto.UserThinDto;
import com.example.springapp1.model.entity.User;

public interface SessionService {

    UserThinDto createSession(User user);

    User getUserFromSession(String sessionId);

    void closeSession(String sessionId);

    void updateSessionActivity(String sessionId);

    boolean isSessionActive(String sessionId);
}

