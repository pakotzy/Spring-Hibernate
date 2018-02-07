package com.pakotzy.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LuckyFortuneService implements FortuneService {
    @Value("${fortunes}")
    private String luckyFortune;

    @Override
    public String getFortune() {
        return luckyFortune;
    }
}
