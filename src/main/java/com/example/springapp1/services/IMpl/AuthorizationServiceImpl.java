package com.example.springapp1.services.IMpl;

import com.example.springapp1.client.UserClient;
import com.example.springapp1.model.dto.UserThinDto;
import com.example.springapp1.model.web.LoginParams;
import com.example.springapp1.services.AuthorizationService;
import com.example.springapp1.services.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AuthorizationServiceImpl implements AuthorizationService {

    SessionService sessionService;
    UserClient userClient;

    @Override
    public UserThinDto login(LoginParams loginParams) {
        return userClient.getAuthorizedUser(loginParams)
                .map(sessionService::createSession)
                .orElseThrow(() ->  new ResponseStatusException(NOT_FOUND,
                        "Неверные данные для входа. Повторите попытку!"));
    }

    @Override
    public void logout(String sessionId) {
        sessionService.closeSession(sessionId);
    }
}
