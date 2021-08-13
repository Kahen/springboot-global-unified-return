package com.example.demo.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;

/**
 * @author kahen
 * @date 2021/8/13
 * 拦截Controller方法的返回值，统一处理返回值/响应体，一般用来统一返回格式，加解密，签名等等
 */
public interface ResponseBodyAdvise<T> {
    /**
     * 是否支持advice功能
     * true 支持，false 不支持
     */
    boolean supports(MethodParameter var1, Class<? extends HttpMessageConverter<?>> var2);

    /**
     * 对返回的数据进行处理
     */
    @Nullable
    T beforeBodyWrite(@Nullable T var1, MethodParameter var2, MediaType var3, Class<? extends HttpMessageConverter<?>> var4, ServerHttpRequest var5, ServerHttpResponse var6);
}
