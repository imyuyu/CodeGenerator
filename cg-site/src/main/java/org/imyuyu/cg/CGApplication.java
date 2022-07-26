package org.imyuyu.cg;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@AllArgsConstructor
@SpringBootApplication
public class CGApplication {

    public static void main(String[] args) {
        SpringApplication.run(CGApplication.class, args);
    }
}
