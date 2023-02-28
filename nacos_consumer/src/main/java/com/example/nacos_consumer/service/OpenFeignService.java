package com.example.nacos_consumer.service;

import com.example.nacos_consumer.service.impl.OpenFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "${service-url.nacos-user-service}", fallback = OpenFeignServiceImpl.class)
public interface OpenFeignService {
    @GetMapping(value = "/msb/{id}")
    public String getServerPort(@PathVariable("id") Long id);
}
