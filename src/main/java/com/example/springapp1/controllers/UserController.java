package com.example.springapp1.controllers;

import com.example.springapp1.controllers.doc.UserDoc;
import com.example.springapp1.model.dto.UserDto;
import com.example.springapp1.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserController implements UserDoc {

    UserService userService;

    @Override
    @GetMapping
    public ResponseEntity<UserDto> getUserInfo (@RequestHeader String sessionId) {
        return ok(userService.getUserInfo(sessionId));
    }
}
