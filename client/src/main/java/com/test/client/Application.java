package com.test.client;

import com.test.client.rpc.RpcClientSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.test")
public class Application {

    @Autowired
    private RpcClientSample rpcClientSample;

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return rpcClientSample.sayHello("Pelin_Li");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
