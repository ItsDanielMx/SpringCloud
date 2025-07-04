package org.example.springcloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GreetingController {

    @GetMapping("/greetings")
    public Mono<String> helloWorld() {
        return Mono.just("Hello World!");
    }
}
