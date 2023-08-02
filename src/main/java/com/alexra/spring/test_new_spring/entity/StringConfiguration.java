package com.alexra.spring.test_new_spring.entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StringConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(StringRepository stringRepository){
        return  args -> {
            stringRepository.saveAll(List.of(
                    new Str("Amazon")
            ));
        };
    }
}
