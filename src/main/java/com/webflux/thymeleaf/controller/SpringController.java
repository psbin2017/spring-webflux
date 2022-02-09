package com.webflux.thymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class SpringController {

    @GetMapping(value = "/spring/projects")
    public Mono<String> projects(
        @RequestParam(value = "location", defaultValue = "disabled") String location,
        ServerWebExchange exchange,
        Model model
    ) {
        if ( "enabled".equals(location) ) {
            exchange.getResponse().getHeaders().add("proxy-mode", "enabled");
            return Mono.just("redirect:/spring/support");
        }
        return Mono.just("/index");
    }

    @GetMapping(value = "/header")
    public Mono<String> header(ServerWebExchange exchange) {
        log.info("[원본 헤더] :: " + exchange.getRequest().getHeaders().toString());

        // addAll start
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setConnection("keep-alive");
        ServerHttpRequest mutateAddAllRequest = exchange.getRequest().mutate()
                .headers(originHeaders -> originHeaders.addAll(httpHeaders))
                .build();
        exchange.mutate().request(mutateAddAllRequest).build();

        log.info("[addAll] :: " + exchange.getRequest().getHeaders().toString());
        // addAll end

        // setAll start
        Map<String, String> httpHeadersV2 = new HashMap<>();
        httpHeadersV2.put("Connection", "keep-alive");
        ServerHttpRequest mutateSetAllRequest = exchange.getRequest().mutate()
                .headers(originHeaders -> originHeaders.setAll(httpHeadersV2))
                .build();
        exchange.mutate().request(mutateSetAllRequest).build();

        log.info("[setAll] :: " + exchange.getRequest().getHeaders().toString());
        // setAll End

        return Mono.just("/index");
    }
}
