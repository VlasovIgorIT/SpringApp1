package com.example.springapp1.controllers;

import com.example.springapp1.models.web.LoginParams;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.http.ResponseEntity.ok;

@RequestMapping
public class LoginController {

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginParams loginParams) {
        return ok(null);
    }
}
