package com.example.springapp1.services;

import com.example.springapp1.model.dto.UserDto;

public interface UserService {

    UserDto getUserInfo(String sessionId);
}
