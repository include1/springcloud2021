package com.zm.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
//这是一个全局过滤器
public class MyLogGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求的地址，校验是否携带指定参数
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if(null == name){
            log.info("该用户不存在o(╥﹏╥)o");
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return response.setComplete();
        }else{
            log.info("校验成功，成功通过");
            return chain.filter(exchange);
        }

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
