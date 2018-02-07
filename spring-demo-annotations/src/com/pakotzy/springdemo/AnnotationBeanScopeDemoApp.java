package com.pakotzy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
//        Load Spring configuration file
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("applicationContext.xml");
//        Get bean from container
        Coach coach = container.getBean("esportCoach", Coach.class);
        Coach coach1 = container.getBean("esportCoach", Coach.class);
//        Do work
        System.out.println("Is equal? " + (coach == coach1));
        System.out.println(coach.getDailyFortune());
        System.out.println(coach1.getDailyFortune());
//        Clean up
        container.close();
    }
}
