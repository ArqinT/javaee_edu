package com.springinaction.springidol;

/**
 * Created by artemtursunov on 10.01.17.
 */
public class Magician2 implements MindReader {
    private String thoughts;

    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer’s thoughts");
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
