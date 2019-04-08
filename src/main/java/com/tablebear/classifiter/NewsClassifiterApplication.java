package com.tablebear.classifiter;

import com.tablebear.classifiter.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class NewsClassifiterApplication implements CommandLineRunner {

    @Autowired
    NewService service;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NewsClassifiterApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run("启动");
    }


    @Override
    public void run(String... args) throws Exception {
        for (String str : args) {
            System.out.println(str);
        }
        service.runLoadModelAndUse();
        exit(0);
    }
}
