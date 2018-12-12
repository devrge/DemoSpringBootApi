package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@RestController
public class DemoControllerAsync {

    private final Logger logger = LoggerFactory.getLogger(DemoController.class);

    /**
     * Example async endpoint that returns a Future freeing up the servlet thread
     * to start processing more requests.
     *
     * This can also be done using DeferredResults or calling methods with @Async
     * annotation to obtain a Future (Requires @EnableAsync).
     * @return A hello world string.
     */
    @RequestMapping(value = "/helloAsync", method = RequestMethod.GET)
    public Future<String> getHelloWorld() {
        logger.debug("Request Received");

        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.debug("Finished Request!");
            return "Hello World!";
        });

        logger.debug("Request Thread Released");
        return result;
    }
}
