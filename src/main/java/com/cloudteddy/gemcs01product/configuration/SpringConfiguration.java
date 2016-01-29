package com.cloudteddy.gemcs01product.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by kimtung on 1/27/16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.cloudteddy.gemcs01product")
public class SpringConfiguration {

}
