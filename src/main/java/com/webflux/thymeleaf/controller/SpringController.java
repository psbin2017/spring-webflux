package com.webflux.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

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
}
