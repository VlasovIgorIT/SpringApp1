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
        if (!request.getRequestURI().equals("/login") && !request.getRequestURI().equals("/login/")) {
            String sessionId = request.getHeader("sessionId");
            if (sessionId != null && sessionService.isSessionActive(sessionId)) {
                sessionService.updateSessionActivity(sessionId);
                return true; // Пропускаем запрос
            } else {
                response.sendRedirect("/login"); // Перенаправляем на страницу логина
                return false; // Отменяем обработку запроса
            }
        } else {
            return true; // Пропускаем запрос, если он уже направлен на /login
        }
    }
}