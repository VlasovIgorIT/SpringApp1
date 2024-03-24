package com.example.springapp1.services.IMpl;

import com.example.springapp1.mapper.UserMapper;
import com.example.springapp1.models.dto.UserThinDto;
import com.example.springapp1.models.entity.User;
import com.example.springapp1.services.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.currentTimeMillis;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class SessionServiceImpl implements SessionService {

    UserMapper userMapper;
    Map<String, User> sessionMap = new HashMap<>();
    Map<String, Long> lastActivityByUserId = new HashMap<>(); // Хранение сессий

    @Override
    public UserThinDto createSession(User user) {
        val sessionName = user.getId() + currentTimeMillis();
        lastActivityByUserId.put(sessionName, currentTimeMillis());
        sessionMap.put(sessionName, user);
        return userMapper.toThinDto(user);
    }

    @Override
    public User getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    public void closeSession(String sessionId) {
        lastActivityByUserId.remove(sessionId);
    }


    public void updateSessionActivity(String sessionId) {
        lastActivityByUserId.put(sessionId, currentTimeMillis());
    }

    public boolean isSessionActive(String sessionId) {
        val halfOfHourMillis = (30 * 60 * 1000);
        val lastActiveTime = lastActivityByUserId.get(sessionId);

        return lastActiveTime != null &&
                (currentTimeMillis() - lastActiveTime) <= halfOfHourMillis;
    }

    @Scheduled(fixedDelay = 600000)
    private void closeInactiveSessions() {
        lastActivityByUserId.entrySet().stream()
                .filter(entry -> !isSessionActive(entry.getKey()))
                .forEach(entry -> closeSession(entry.getKey()));
    }
}