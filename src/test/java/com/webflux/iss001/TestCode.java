package com.webflux.iss001;

import configuration.SystemPropertyActiveProfileResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "qa", resolver= SystemPropertyActiveProfileResolver.class)
public class TestCode {

    @Value("${hello-world}")
    public String helloWorld;

    @DisplayName("hello world")
    @Test
    void test() {
        System.out.println( helloWorld );
    }
}
