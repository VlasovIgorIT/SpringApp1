package com.example.springapp1.services.IMpl;

import com.example.springapp1.client.UserClient;
import com.example.springapp1.model.dto.UserThinDto;
import com.example.springapp1.model.entity.User;
import com.example.springapp1.model.web.LoginParams;
import com.example.springapp1.services.AuthorizationService;
import com.example.springapp1.services.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AuthorizationServiceImpl implements AuthorizationService {

    SessionService sessionService;
    UserClient userClient;

    @Override
    public UserThinDto login(LoginParams loginParams) {
//        return userClient.getAuthorizedUser(loginParams)
//                .map(sessionService::createSession)
//                .orElseThrow(() ->  new ResponseStatusException(NOT_FOUND,
//                        "Неверные данные для входа. Повторите попытку!"));

        val user = User.builder()
                .id("1")
                .name("Name")
                .INN("12345466546")
                .address("Ленина 1")
                .email("user@example.com")
                .phone("+79991234567")
                .password("password")
                .build();
        return sessionService.createSession(user);
    }

    @Override
    public void logout(String sessionId) {
        sessionService.closeSession(sessionId);
    }
}
