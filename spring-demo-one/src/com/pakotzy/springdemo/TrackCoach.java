package com.pakotzy.springdemo;

public class TrackCoach implements Coach {
    FortuneService fortuneService;
    String emailAddress;
    String teamName;

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run hard 5k";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getAdditionalInfo() {
        return "Email Address - " + emailAddress +
                "\nTeam Name - " + teamName;
    }
}
