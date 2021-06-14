package com.webflux.iss002.api;

import com.webflux.iss002.dto.response.PathPatternResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController("/sample")
public class SampleApi {

    @GetMapping("/{onlyPath}/{regexPath:[a-z]+}/{*endPath}")
    public Mono<PathPatternResponseDto> pathPattern(
        @PathVariable String onlyPath,
        @PathVariable String regexPath,
        @PathVariable String endPath
    ) {

        PathPatternResponseDto response = PathPatternResponseDto.builder()
                .onlyPath(onlyPath)
                .regexPath(regexPath)
                .endPath(endPath)
                .build();

        log.info( response.toString() );

        return Mono.just(response);
    }

}
