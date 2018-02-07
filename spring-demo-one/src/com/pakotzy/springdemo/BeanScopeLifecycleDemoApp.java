package com.pakotzy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeLifecycleDemoApp {
    public static void main(String[] args) {
//        Load Spring configuration file
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("beanScopeLifecycle-applicationContext.xml");

//        Get bean object
        EsportCoach theCoach = container.getBean("coach", EsportCoach.class);
        EsportCoach superCoach = container.getBean("coach", EsportCoach.class);

//        Do stuff
        System.out.println("Are coaches equal? " + (theCoach==superCoach));
        System.out.println("theCoach in memory - " + theCoach);
        System.out.println("superCoach in memory - " + superCoach);

//        Close spring container
        container.close();
    }
}
