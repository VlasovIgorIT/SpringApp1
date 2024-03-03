package com.example.springapp1.client.fallback;

import com.example.springapp1.client.LensClient;
import com.example.springapp1.models.entity.Lens;
import com.example.springapp1.models.web.LensParams;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LensClientFallback implements LensClient {

    @Override
    public List<Lens> getLensesByFilter(LensParams lensParams) {

        return null;
    }

}
