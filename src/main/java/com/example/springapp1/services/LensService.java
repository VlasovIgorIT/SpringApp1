package com.example.springapp1.services;

import com.example.springapp1.models.Lens;

import java.util.List;

public interface LensService {
    List<Lens> getAll();
    Lens getById(Long id);
}