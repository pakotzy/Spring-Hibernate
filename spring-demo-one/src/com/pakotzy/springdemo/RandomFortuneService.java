package com.pakotzy.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    String[] fortunes = {"Today is your lucky day", "Today is a bad day for you", "Stars are neutral for you today"};

    @Override
    public String getFortune() {
        Random random = new Random();
        return fortunes[random.nextInt(3)];
    }
}
