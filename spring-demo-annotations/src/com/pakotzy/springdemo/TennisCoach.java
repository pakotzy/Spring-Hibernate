package com.pakotzy.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
//    Field injection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

//    Constructor injection
/*    @Autowired
    public TennisCoach(@Qualified("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Back flip 360 no-scope shot!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    Setter injection
/*    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> AnnotationDemoApp: Inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }*/
}
