package com.example.springapp1.services;

import com.example.springapp1.models.entity.Lens;
import com.example.springapp1.models.web.LensFilterParams;

import java.util.List;

public interface LensService {

    Lens getById(String id);

    List<Lens> getByFilter(LensFilterParams lensFilterParams);
}