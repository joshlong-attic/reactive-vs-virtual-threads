package com.example.blocking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@SpringBootApplication
public class BlockingApplication {

    @GetMapping("/")
    User user() throws InterruptedException {
        Thread.sleep(100);
        return new User(1, "Blocking");
    }

    public static void main(String[] args) {
        SpringApplication.run(BlockingApplication.class, args);
    }

}

record User(int id, String name) {
}