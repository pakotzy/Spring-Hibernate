package com.pakotzy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
//        Load Spring Configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        Load bean class
        Coach coach = context.getBean("esportCoach", Coach.class);

//        Invoke a method
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

//        Close Spring container
        context.close();
    }
}
