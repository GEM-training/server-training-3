package com.cloudteddy.cs01.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kimtung on 01/02/16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.cloudteddy.cs01")
public class SpringConfig {
}
