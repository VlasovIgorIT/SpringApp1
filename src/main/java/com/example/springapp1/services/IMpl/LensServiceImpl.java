package com.example.springapp1.services.IMpl;

import com.example.springapp1.models.Lens;
import com.example.springapp1.services.LensService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Primary
@RequiredArgsConstructor
public class LensServiceImpl implements LensService {


    @Override
    public List<Lens> getAll() {
        return new ArrayList<>();
    }

    @Override
    public Lens getById(Long id) {
        return new Lens();
    }
}
