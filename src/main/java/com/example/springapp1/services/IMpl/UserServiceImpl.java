package com.example.springapp1.services.IMpl;

import com.example.springapp1.mapper.UserMapper;
import com.example.springapp1.model.dto.UserDto;
import com.example.springapp1.services.SessionService;
import com.example.springapp1.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    SessionService sessionService;
    UserMapper userMapper;

    @Override
    public UserDto getUserInfo(String sessionId) {
        return userMapper.toDto(sessionService.getUserFromSession(sessionId));
    }
}