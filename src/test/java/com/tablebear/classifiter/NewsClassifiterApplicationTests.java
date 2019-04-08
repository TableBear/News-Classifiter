package com.tablebear.classifiter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsClassifiterApplicationTests {

    Runnable run = () -> System.out.println("Hello World");

    @Test
    public void contextLoads() {
        run.run();
        System.out.println();
    }

}
