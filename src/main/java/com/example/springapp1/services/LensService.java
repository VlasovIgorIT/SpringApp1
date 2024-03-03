package com.example.springapp1.services;

import com.example.springapp1.models.entity.Lens;
import com.example.springapp1.models.web.LensParams;

import java.util.List;

public interface LensService {

    List<Lens> getAll();

    Lens getById(Long id);

    List<Lens> getAllByFilter(LensParams lensParams);
}
