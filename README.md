# MCP Demo

这是一个使用Spring AI MCP (Model Context Protocol)的示例项目，包含了服务端和客户端的实现。

## 环境要求

- Java 17 或更高版本
- Maven 3.6 或更高版本
- Git

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

### 1. 克隆项目

```bash
git clone https://github.com/nyzhc/mcp-demo.git
cd mcp-demo
```

### 2. 构建项目

```bash
# 构建服务端
cd mcp-server
mvn clean package

# 构建客户端
cd ../mcp-client
mvn clean package
```

### 3. 启动服务

首先启动服务端：
```bash
cd mcp-server
mvn spring-boot:run
```

然后在新的终端窗口启动客户端：
```bash
cd mcp-client
mvn spring-boot:run
```

### 4. 测试API

```bash
# 搜索Java相关内容
curl "http://localhost:8080/search?keyword=java"

# 搜索Python相关内容
curl "http://localhost:8080/search?keyword=python"
```

### 5. 预期输出

搜索Java时的输出示例：
```json
[
  "Java基础教程",
  "Java高级特性",
  "Java并发编程"
]
```

搜索Python时的输出示例：
```json
[
  "Python入门指南",
  "Python数据分析",
  "Python机器学习"
]
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

## 常见问题

1. 如果遇到端口占用问题，可以在application.yml中修改端口号

2. 确保先启动服务端，再启动客户端

3. 如果遇到Java版本问题，请确保安装了Java 17或更高版本：
```bash
java -version
```

4. 如果需要修改搜索内容，可以编辑 `mcp-server/src/main/java/com/example/mcp/tool/SearchTool.java` 文件

## 贡献指南

1. Fork 本仓库
2. 创建新的分支: `git checkout -b feature/your-feature`
3. 提交更改: `git commit -am 'Add some feature'`
4. 推送到分支: `git push origin feature/your-feature`
5. 提交 Pull Request

## 许可证

MIT 