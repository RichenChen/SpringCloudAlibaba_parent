package com.mashibing.cloudalibabanacos9002.controller;

import com.msb.cloudalibabacommon.entity.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class DemoController {

    @Value("${server.port}")
    private String serverPort;

    private static Map<Long, String> hash = new HashMap<>();
    static {
        hash.put(1L, "鼠标");
        hash.put(2L, "键盘");
        hash.put(3L, "耳机");
    }
    @GetMapping(value = "/msb/{id}")
    public String getServerPort(@PathVariable("id") Long id){
        JsonResult<String> jsonResult = new JsonResult<>(id, hash.get(id));
        return "port: " + serverPort + "obj: " + jsonResult;

    }
}
