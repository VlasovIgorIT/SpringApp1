package com.example.springapp1.client.fallback;

import com.example.springapp1.client.LensClient;
import com.example.springapp1.model.entity.Lens;
import com.example.springapp1.model.web.LensFilterParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Optional.empty;

@Slf4j
@Component
public class LensClientFallback implements FallbackFactory<LensClient> {


    @Override
    public LensClient create(Throwable cause) {
        return new LensClient() {
            @Override
            public List<Lens> getLensesByFilter(LensFilterParams lensFilterParams) {
                return emptyList();
            }

            @Override
            public Optional<Lens> getById(String id) {
                return empty();
            }

            @Override
            public List<Lens> getByIdList(List<String> idList) {
                return emptyList();
            }
        };
    }
}
