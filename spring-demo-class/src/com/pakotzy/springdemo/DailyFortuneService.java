package com.pakotzy.springdemo;

import org.springframework.stereotype.Component;

//@Component
public class DailyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Good day";
    }
}
