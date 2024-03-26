package com.example.springapp1.client.fallback;

import com.example.springapp1.client.UserClient;
import com.example.springapp1.model.entity.Order;
import com.example.springapp1.model.entity.User;
import com.example.springapp1.model.web.LoginParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Optional.empty;

@Slf4j
@Component
public class UserClientFallback implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable cause) {
        return new UserClient() {
            @Override
            public Optional<User> getAuthorizedUser(LoginParams params) {
                return empty();
            }

            @Override
            public List<Order> getOrderList(String sessionId) {
                return emptyList();
            }
        };
    }
}
