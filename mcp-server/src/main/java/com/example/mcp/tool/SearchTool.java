package com.example.mcp.tool;

import org.springframework.ai.mcp.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SearchTool {

    private final Map<String, List<String>> dataStore;

    public SearchTool() {
        // 初始化一些示例数据
        dataStore = new HashMap<>();
        List<String> javaList = new ArrayList<>();
        javaList.add("Java基础教程");
        javaList.add("Java高级特性");
        javaList.add("Java并发编程");
        dataStore.put("java", javaList);

        List<String> pythonList = new ArrayList<>();
        pythonList.add("Python入门指南");
        pythonList.add("Python数据分析");
        pythonList.add("Python机器学习");
        dataStore.put("python", pythonList);
    }

    @Tool(name = "search",
          description = "搜索相关内容",
          parameters = {
              @Tool.Parameter(name = "keyword", description = "搜索关键词")
          })
    public List<String> search(String keyword) {
        keyword = keyword.toLowerCase();
        return dataStore.getOrDefault(keyword, List.of("未找到相关内容"));
    }
} 