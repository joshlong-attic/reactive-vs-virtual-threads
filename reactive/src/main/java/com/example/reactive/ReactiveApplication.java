package com.example.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
@ResponseBody
@SpringBootApplication
public class ReactiveApplication {

    @GetMapping("/")
    Mono<User> home() {
        return Mono
                .delay(Duration.ofMillis(100))
                .map(x -> new User(1, "Reactive"));
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }
}

record User(int id, String name) {
}