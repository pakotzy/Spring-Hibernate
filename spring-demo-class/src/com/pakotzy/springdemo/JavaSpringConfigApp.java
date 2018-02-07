package com.pakotzy.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaSpringConfigApp {
    public static void main(String[] args) {
//        Load configuration file
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        Get bean from the container
        EsportCoach coach = container.getBean("esportCoach", EsportCoach.class);
//        Call some methods
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getInfo());
//        Clean up container
        container.close();
    }
}
