package com.example.springapp1.client;

import com.example.springapp1.client.fallback.LensClientFallback;
import com.example.springapp1.models.entity.Lens;
import com.example.springapp1.models.web.LensParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Primary
@FeignClient(url = "${feignUrl}", fallback = LensClientFallback.class)
public interface LensClient {

    @PostMapping
    List<Lens> getLensesByFilter(@RequestBody LensParams lensParams);

}
