package com.springinaction.springidol;

/**
 * Created by artemtursunov on 21.12.16.
 */
public class Juggler implements Performer {
    private int beanBags = 3;
    public Juggler() { }
    public Juggler(int beanBags) { this.beanBags = beanBags;
    }
    public void perform() throws PerformanceException {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}
