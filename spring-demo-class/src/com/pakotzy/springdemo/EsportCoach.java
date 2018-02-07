package com.pakotzy.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class EsportCoach implements Coach {
//    @Autowired
    private FortuneService fortuneService;
//    Inject values from a properties file
    @Value("${email}")
    private String email;

    @Value("${team}")
    private String team;

    public EsportCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Grind your game";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getInfo() {
        return "Email: " + email +
                "\nTeam: " + team;
    }
}
