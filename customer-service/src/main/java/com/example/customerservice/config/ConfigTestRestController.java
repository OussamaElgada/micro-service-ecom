package com.example.customerservice.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigTestRestController {

    private final CustomerConfigParams params;

    public ConfigTestRestController(CustomerConfigParams params) {
        this.params = params;
    }

    @GetMapping("/testConfig")
    public CustomerConfigParams testConfig() {
        return params;
    }
}
