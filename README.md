# MCP Demo

这是一个使用Spring AI MCP (Model Context Protocol)的示例项目，包含了服务端和客户端的实现。

## 项目结构

```
mcp-demo/
├── mcp-server/    # MCP服务端
├── mcp-client/    # MCP客户端
└── README.md
```

## 功能特性

- 服务端提供简单的搜索功能
- 客户端通过SSE方式与服务端通信
- 支持异步调用

## 快速开始

### 1. 启动服务端

```bash
cd mcp-server
mvn spring-boot:run
```

### 2. 启动客户端

```bash
cd mcp-client
mvn spring-boot:run
```

### 3. 测试API

```bash
# 搜索Java相关内容
curl "http://localhost:8080/search?keyword=java"

# 搜索Python相关内容
curl "http://localhost:8080/search?keyword=python"
```

## 技术栈

- Spring Boot 3.2.3
- Spring AI MCP 1.0.0-M6
- Project Reactor
- Java 17

## 配置说明

### 服务端配置 (application.yml)

```yaml
spring:
  application:
    name: mcp-server
  main:
    web-application-type: none
    banner-mode: off
ai:
  mcp:
    server:
      stdio: true
      name: demo-mcp-server
      version: 0.0.1
```

### 客户端配置 (application.yml)

```yaml
server:
  port: 8080
spring:
  application:
    name: mcp-client
  ai:
    mcp:
      client:
        enabled: true
        name: demo-mcp-client
        version: 1.0.0
        request-timeout: 30s
        type: ASYNC
        sse:
          connections:
            server1:
              url: http://localhost:8090
```

## 许可证

MIT 