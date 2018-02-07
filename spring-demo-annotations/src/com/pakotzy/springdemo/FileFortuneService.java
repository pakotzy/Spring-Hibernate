package com.pakotzy.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

@Component
public class FileFortuneService implements FortuneService {
//      Pre loading from the file system
    private String[] fortunes;
    private Random random = new Random();

    @Override
    public String getFortune() {
        return fortunes[random.nextInt(fortunes.length)];
    }

//    Initialization method
    @PostConstruct
    private void preloadFortunes() {
        String fileName = "fortunes.txt";
//        Try with resources to avoid manual cleanup
        try (Stream<String> stream = Files.lines(Paths.get("src", fileName))) {
            fortunes = stream.toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
