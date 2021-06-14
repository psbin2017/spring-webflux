package com.webflux;

import com.webflux.iss001.GreetingWebClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        GreetingWebClient greetingWebClient = new GreetingWebClient();
        log.info(greetingWebClient.getResult());
    }

}
