# Spring Boot 统一后端返回格式

## 目标基于SpringBoot前后端分离开发模式下，能够友好的返回统一的标准格式,以及处理全局异常

在默认情况下，SpringBoot的返回格式常见的有三种：

第一种：返回 String

```java
@GetMapping("/hello")
public String getStr(){
        return"hello";
        }
```

此时调用接口获取到的返回值是这样：

```text
hello
```

第二种: 返回自定义对象 此时调用接口获取到的返回值是这样：

```json
{
  "id": 1,
  "name": "dog"
}
```

第三种: 接口异常 此时接口返回值是这样:

```json
{
  "timestamp": "2021-08-13T08:05:15.423+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/wrong"
}
```

本示例是通过借助SpringBoot提供的ResponseBodyAdvice,拦截Controller方法的返回值，统一处理返回值/响应体，达到用来用来统一返回格式，加解密，签名等等。

@RestControllerAdvice是@RestController注解的增强，可以实现三个方面的功能：

- 全局异常处理

- 全局数据绑定

- 全局数据预处理

### 项目返回结果实例

返回 string：

```json
{
  "status": 100,
  "message": "操作成功",
  "data": "hello world",
  "timestamp": 1628851871669
}
```

返回 自定义实体：

```json
{
  "status": 100,
  "message": "操作成功",
  "data": [
    {
      "id": "id",
      "name": "张三"
    }
  ],
  "timestamp": 1628851920556
}
```

返回 错误：

```json
{
  "status": 500,
  "message": "/ by zero",
  "data": null,
  "timestamp": 1628851951704
}
```

返回 自定义异常

```json
{
  "status": 500,
  "message": "自定义异常",
  "data": null,
  "timestamp": 1628851997734
}
```

