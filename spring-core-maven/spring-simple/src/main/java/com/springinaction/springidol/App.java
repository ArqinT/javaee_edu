package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by artemtursunov on 22.12.16.
 */
public class App {
    public void main(String[] arg) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConfig.xml") {
        };
        Performer performer = (Performer) ctx.getBean("poeticDuke");
        performer.perform();
    }
}
