package com.example.springapp1.services.IMpl;

import com.example.springapp1.client.UserClient;
import com.example.springapp1.models.dto.UserThinDto;
import com.example.springapp1.models.web.LoginParams;
import com.example.springapp1.services.AuthorizationService;
import com.example.springapp1.services.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
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
        val user = userClient.getAuthorizedUser(loginParams)
                .orElseThrow(() ->  new ResponseStatusException(NOT_FOUND,
                        "Неверные данные для входа. Повторите попытку!"));

        return sessionService.createSession(user);
    }

    @Override
    public void logout(String sessionId) {
        sessionService.closeSession(sessionId);
    }
}
