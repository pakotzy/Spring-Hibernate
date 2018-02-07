package com.pakotzy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDependencyInjectionApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext service =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        EsportCoach trackCoach = service.getBean("esportCoach", EsportCoach.class);

        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyFortune());
        System.out.println(trackCoach.getAdditionalInfo());

        service.close();
    }
}
