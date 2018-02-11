package com.boot.dasroot.controller;

import com.boot.dasroot.vo.Greeting;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class HomeController {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s!";
    @RequestMapping("/")
    public Greeting home() {
        return new Greeting(counter.incrementAndGet(), String.format(template, "World"));
    }
}
