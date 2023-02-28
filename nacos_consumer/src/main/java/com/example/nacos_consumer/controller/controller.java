package com.example.nacos_consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.msb.cloudalibabacommon.entity.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class controller {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @RequestMapping("consumer/nacos/{id}")
    @SentinelResource(value = "getDiscovery", fallback = "fallbackHandler")
    public String getDiscovery(@PathVariable("id") Long id) {
        if (id <= 3) {
            return restTemplate.getForObject(serverUrl + "/msb/" + id, String.class);
        } else {
            throw new NullPointerException("记录不存在");
        }
    }

    public String fallbackHandler(Long id, Throwable throwable) {
        return new JsonResult<String>(id, throwable.toString()).toString();
    }
}
