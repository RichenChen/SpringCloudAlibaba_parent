package com.example.nacos_consumer.controller;

import com.example.nacos_consumer.service.OpenFeignService;
import com.msb.cloudalibabacommon.entity.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignController {
    @Autowired
    private OpenFeignService openFeignService;

    @RequestMapping("consumer/openfeign/{id}")
    public String getInfo(@PathVariable("id") Long id) {
        if (id > 3) {
            throw new RuntimeException("没有这个id");
        }
        return openFeignService.getServerPort(id);
    }
}
