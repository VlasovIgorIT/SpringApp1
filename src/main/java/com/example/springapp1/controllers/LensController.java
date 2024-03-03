package com.example.springapp1.controllers;

import com.example.springapp1.models.entity.Lens;
import com.example.springapp1.models.web.LensParams;
import com.example.springapp1.services.LensService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RequestMapping("/lens")
@RequiredArgsConstructor
@RestController
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LensController {

    LensService lensService;

    @GetMapping
    public ResponseEntity<List<Lens>> getAllLens() {
        return ResponseEntity.ok(lensService.getAll());
    }

    @PostMapping
    public ResponseEntity<List<Lens>> getLensesByFilter(@RequestBody LensParams lensParams) {
        return ResponseEntity.ok(lensService.getAllByFilter(lensParams));
    }



}
