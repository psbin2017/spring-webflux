package com.webflux.iss002.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
public class PathPatternResponseDto {

    @Getter
    private String onlyPath;

    @Getter
    private String regexPath;

    @Getter
    private String endPath;

    @Builder
    public PathPatternResponseDto(String onlyPath, String regexPath, String endPath) {
        this.onlyPath = onlyPath;
        this.regexPath = regexPath;
        this.endPath = endPath;
    }
}
