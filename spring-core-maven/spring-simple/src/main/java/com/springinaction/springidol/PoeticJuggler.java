package com.springinaction.springidol;

/**
 * Created by artemtursunov on 22.12.16.
 */
public class PoeticJuggler extends Juggler {
    private Poem poem;
    public PoeticJuggler(Poem poem) {
        // Внедрение поэмы super();
        this.poem = poem;
    }
    public PoeticJuggler(int beanBags, Poem poem)
    {
        // Внедрение количества super(beanBags);
        // мячиков и поэмы this.poem = poem;
    }
    public void perform() throws PerformanceException {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}
