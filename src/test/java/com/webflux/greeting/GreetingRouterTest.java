package com.webflux.greeting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("테스트 클라이언트, 성공")
    @Test
    void greetingRouting_exchange_success() {
        // given
        webTestClient
                // when
                .get().uri("/greeting")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                // then
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Greeting Spring Reactive");
    }
}