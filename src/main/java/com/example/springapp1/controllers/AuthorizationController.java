package com.example.springapp1.controllers;

import com.example.springapp1.controllers.doc.AuthorizationDoc;
import com.example.springapp1.model.dto.UserThinDto;
import com.example.springapp1.model.web.LoginParams;
import com.example.springapp1.services.AuthorizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AuthorizationController implements AuthorizationDoc {

    AuthorizationService authorizationService;

    @GetMapping
    public String login () {
        return "login";
    }

    @Override
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody @Valid LoginParams loginParams, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return badRequest().body(errors);
        }

        UserThinDto userThinDto = authorizationService.login(loginParams);
        return ok(userThinDto);
    }

    @PostMapping("/logout")
    public String logout(@RequestHeader String sessionId) {
        authorizationService.logout(sessionId);
        return "login";
    }
}