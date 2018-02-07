package com.pakotzy.springdemo;

public class EsportCoach implements Coach {
    FortuneService fortuneService;
    String emailAddress;
    String teamName;

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public EsportCoach() {}

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

    public String getAdditionalInfo() {
        return "Email Address - " + emailAddress +
                "\nTeam Name - " + teamName;
    }

    public void initStuff() {
        System.out.println("EsportCoach: initStuff");
    }

    public void cleanupStuff() {
        System.out.println("EsportCoach: cleanupStuff");
    }
}
