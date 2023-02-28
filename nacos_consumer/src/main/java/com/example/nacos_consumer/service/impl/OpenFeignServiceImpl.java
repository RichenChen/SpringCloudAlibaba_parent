package com.example.nacos_consumer.service.impl;

import com.example.nacos_consumer.service.OpenFeignService;
import org.springframework.stereotype.Component;

@Component
public class OpenFeignServiceImpl implements OpenFeignService {
    @Override
    public String getServerPort(Long id) {
        return "服务降级返回！";
    }
}
