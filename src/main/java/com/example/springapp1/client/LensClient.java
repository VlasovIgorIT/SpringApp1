package com.example.springapp1.client;

import com.example.springapp1.client.fallback.LensClientFallback;
import com.example.springapp1.models.entity.Lens;
import com.example.springapp1.models.web.LensFilterParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(url = "${feignUrl}/lenses", fallbackFactory = LensClientFallback.class)
public interface LensClient {

    @PostMapping
    List<Lens> getLensesByFilter(@RequestBody LensFilterParams lensFilterParams);

    @GetMapping("/{id}")
    Optional<Lens> getById(@PathVariable String id);

    @PostMapping("/batch")
    List<Lens> getByIdList(@RequestBody List<String> idList);
}