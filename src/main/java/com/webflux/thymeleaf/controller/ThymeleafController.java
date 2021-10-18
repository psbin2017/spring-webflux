package com.webflux.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Controller
public class ThymeleafController {

    @GetMapping(value = "/index")
    public Mono<String> index(
            ServerWebExchange exchange,
            Model model
    ) {
        exchange.getResponse().getHeaders().add("Index", "World");
        model.addAttribute("title", "Index World");
        return Mono.just("/index");
    }

    @GetMapping(value = "/redirect")
    public Mono<String> redirect(
            ServerWebExchange exchange,
            Model model
    ) {
        // 응답에 헤더는 포함되지만 모델 객체는 포함되지 않는다.
        exchange.getResponse().getHeaders().add("Redirect", "World");
        model.addAttribute("title", "Redirect World");
        return Mono.just("redirect:/index");
    }

}
