package io.github.adamkuzniarski.podcastpublisherapi.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HealthController {

    private final Environment environment;

    public HealthController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/api/health")
    public Map<String, Object> health() {
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("status", "UP");
        response.put("application", environment.getProperty("spring.application.name", "podcast-publisher-api"));
        response.put("timestamp", Instant.now().toString());
        response.put("javaVersion", System.getProperty("java.version"));
        response.put("osName", System.getProperty("os.name"));
        response.put("activeProfiles", environment.getActiveProfiles());
        response.put("uptimeMs", ManagementFactory.getRuntimeMXBean().getUptime());

        return response;
    }
}