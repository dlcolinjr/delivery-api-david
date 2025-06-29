package com.deliverytech.delivery_api.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class HealthController {

    @ResponseBody
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "timestamp", LocalDateTime.now().toString(),
            "service", "Delivery API",
            "javaVersion", System.getProperty("java.version")
        );
    }

    @ResponseBody
    @GetMapping("/info")
    public AppInfo info() {
        return new AppInfo(
            "Delivery Tech API",
            "1.0.0",
            "David",
            "JDK 21",
            "Spring Boot 3.5.3"
        );
    }

    // Record para demonstrar recurso do Java 14+ (disponível no JDK 21)
    public record AppInfo(
        String application,
        String version,
        String developer,
        String javaVersion,
        String framework
    ) {}
}
