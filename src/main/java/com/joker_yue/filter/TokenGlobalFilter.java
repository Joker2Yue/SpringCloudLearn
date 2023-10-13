package com.joker_yue.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 网关全局过滤器
 * @author Joker
 * @version 1.0
 * @date 2023/8/23 21:08
 */
@Component
public class TokenGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 如何获取参数？我们之前可以通过HttpServletRequest.getParameter()来获取
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isEmpty(token)) {
            ServerHttpResponse response = exchange.getResponse();   // 从响应中获取
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR); // 500

            String msg = "token is empty";
            DataBuffer msgBuffer = response.bufferFactory().wrap(msg.getBytes());
            return response.writeWith(Mono.just(msgBuffer));
        }

        // token不为空，直接转发到真实服务
        return chain.filter(exchange);
    }
}
