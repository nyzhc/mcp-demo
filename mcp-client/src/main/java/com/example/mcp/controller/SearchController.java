package com.example.mcp.controller;

import org.springframework.ai.mcp.client.McpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    private final McpClient mcpClient;

    public SearchController(McpClient mcpClient) {
        this.mcpClient = mcpClient;
    }

    @GetMapping("/search")
    public Mono<List<String>> search(@RequestParam String keyword) {
        return mcpClient.invokeAsync("search", Map.of("keyword", keyword))
                .map(response -> (List<String>) response);
    }
} 