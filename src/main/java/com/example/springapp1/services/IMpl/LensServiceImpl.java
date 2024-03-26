package com.example.springapp1.services.IMpl;

import com.example.springapp1.client.LensClient;
import com.example.springapp1.model.entity.Lens;
import com.example.springapp1.model.web.LensFilterParams;
import com.example.springapp1.services.LensService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LensServiceImpl implements LensService {

    LensClient lensClient;

    @Override
    public Lens getById(String id) {
        return lensClient.getById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Линза не найдена"));
    }

    @Override
    public List<Lens> getByFilter(LensFilterParams lensFilterParams) {
        return lensClient.getLensesByFilter(lensFilterParams);
    }
}