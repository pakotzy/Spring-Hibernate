package com.pakotzy.springhibernate.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.pakotzy.springhibernate.rest")
public class DemoAppConfig {
}
