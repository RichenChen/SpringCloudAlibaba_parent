package com.msb.cloudalibabasentinel8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.msb.cloudalibabasentinel8401.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {
    @Autowired
    private TestService testService;

    @RequestMapping("/testA")
    @SentinelResource(value = "testA", blockHandler = "testB")
    public String testA(@RequestParam(value = "p1", required = false) String str) {
        return testService.common();
    }

    public String testB(String p1, BlockException e) {
        return "繁忙";
    }

}
