package com.example.springapp1.services.IMpl;

import com.example.springapp1.client.LensClient;
import com.example.springapp1.models.entity.Lens;
import com.example.springapp1.models.web.LensParams;
import com.example.springapp1.services.LensService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@Primary
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LensServiceImpl implements LensService {

    LensClient lensClient;

    @Override
    public List<Lens> getAll() {
        return new ArrayList<>();
    }

    @Override
    public Lens getById(Long id) {
        return new Lens();
    }

    @Override
    public List<Lens> getAllByFilter(LensParams lensParams) {
        return lensClient.getLensesByFilter(lensParams);
    }
}
