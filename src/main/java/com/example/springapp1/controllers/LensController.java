package com.example.springapp1.controllers;

import com.example.springapp1.models.Lens;
import com.example.springapp1.services.LensService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/lens")
@RequiredArgsConstructor
@RestController
public class LensController {
    private final LensService lensService;
    @GetMapping
    public ResponseEntity<List<Lens>> getAllLens() {
        return ResponseEntity.ok(lensService.getAll());
    }



}
