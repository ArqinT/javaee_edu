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
        System.out.println("");
        System.out.println("Duke");
        System.out.println("");
        Performer performer = (Performer) ctx.getBean("poeticDuke");
        performer.perform();
//        System.out.println("");
//        System.out.println("Kenny");
//        System.out.println("");
//        Performer performer1 = (Performer) ctx.getBean("kenny");
//        performer1.perform();
//        System.out.println("");
//        System.out.println("Hank");
//        System.out.println("");
//        Performer performer2 = (Performer) ctx.getBean("hank");
//        performer2.perform();
//        System.out.println("");
//        System.out.println("Carl");
//        System.out.println("");
//        Performer performer3 = (Performer) ctx.getBean("carl");
//        performer3.perform();
//        System.out.println("");
//        System.out.println("Harry");
//        System.out.println("");
//        Performer magician = (Performer) ctx.getBean("harry");
//        magician.perform();
//        System.out.println("Eddie");
//        System.out.println("");
//        Performer performer4 = (Performer) ctx.getBean("eddie");
//        performer4.perform();
    }
}
