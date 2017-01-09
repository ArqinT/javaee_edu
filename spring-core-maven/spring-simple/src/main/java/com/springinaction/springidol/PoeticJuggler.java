package com.springinaction.springidol;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by artemtursunov on 22.12.16.
 */
public class PoeticJuggler extends Juggler {
    private Poem poem;
    @Autowired
    public PoeticJuggler(Poem poem) {
        // Внедрение поэмы
        super();
        this.poem = poem;
    }
    public PoeticJuggler(int beanBags, Poem poem)
    {
        super(beanBags);
        this.poem = poem;
    }
    public void perform() throws PerformanceException {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}
