package com.pakotzy.springdemo;

public class BaseballCoach implements Coach {
    FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "30 min of baseball practice";
    }

    public String getDailyFortune() {
        return "Just Do It: " + fortuneService.getFortune();
    }
}
