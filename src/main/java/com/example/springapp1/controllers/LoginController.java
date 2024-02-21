package com.example.springapp1.controllers;

import com.example.springapp1.models.LoginParams;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class LoginController {
    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginParams loginParams) {




    }
}
