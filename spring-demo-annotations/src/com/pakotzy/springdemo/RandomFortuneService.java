package com.pakotzy.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
/*    private String[] fortunes = {
            "Today is your lucky day!",
            "Today is a bad day for you!",
            "Just some normal day!"
    };*/

//      Value Dependency Injection from Config file
    @Value("${fortunes}")
    private String[] fortunes;

    private Random random = new Random();

    @Override
    public String getFortune() {
        return fortunes[random.nextInt(fortunes.length)];
    }
}
