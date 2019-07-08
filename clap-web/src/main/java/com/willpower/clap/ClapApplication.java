package com.willpower.clap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Powersoft on 2019/4/4.
 */
@EnableAutoConfiguration
@EnableSwagger2
@Configuration
@ComponentScan(basePackages = {"com.willpower.clap"})
public class ClapApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClapApplication.class, args);
    }
}
