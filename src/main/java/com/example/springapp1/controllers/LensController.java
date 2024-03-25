package com.example.springapp1.controllers;

import com.example.springapp1.models.entity.Lens;
import com.example.springapp1.models.web.LensFilterParams;
import com.example.springapp1.services.LensService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lens")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LensController {

    LensService lensService;

    @PostMapping("/search")
    public ResponseEntity<List<Lens>> getLensesByFilter(@RequestBody LensFilterParams lensFilterParams) {
        return ResponseEntity.ok(lensService.getByFilter(lensFilterParams));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lens> getById (@PathVariable String id) {
        return ResponseEntity.ok(lensService.getById(id));
    }
}