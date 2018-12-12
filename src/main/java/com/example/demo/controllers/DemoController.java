package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHelloWorld() {
        logger.debug("Hello World!");
        return "Hello World!";
    }
}
