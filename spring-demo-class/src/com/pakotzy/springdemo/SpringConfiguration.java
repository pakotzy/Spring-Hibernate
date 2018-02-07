package com.pakotzy.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Use @Configuration to mark class as Spring Configuration Container
@Configuration
// Use @PropertySource("path") to load specific properties file
@PropertySource("classpath:properties.prop")
// Use @ComponentScan("packet name") to enable scanning with annotations
//@ComponentScan("com.pakotzy.springdemo")
public class SpringConfiguration {
//    @Bean to define method to expose beans
    @Bean
    public Coach esportCoach() {
//        Inject bean dependencies
        return new EsportCoach(dailyFortuneService());
    }

    @Bean
    public FortuneService dailyFortuneService() {
        return new DailyFortuneService();
    }
}
