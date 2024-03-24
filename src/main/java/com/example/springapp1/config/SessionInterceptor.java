package com.example.springapp1.config;

import com.example.springapp1.services.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class SessionInterceptor implements HandlerInterceptor {

    SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionId = request.getHeader("sessionId");
        if (sessionId == null || !sessionService.isSessionActive(sessionId)) {
            sessionService.closeSession(sessionId);
            response.sendRedirect("/login"); // Перенаправляем на страницу логина
            return false; // Отменяем обработку запроса
        }
        sessionService.updateSessionActivity(sessionId);
        return true; // Продолжаем обработку запроса
    }
}