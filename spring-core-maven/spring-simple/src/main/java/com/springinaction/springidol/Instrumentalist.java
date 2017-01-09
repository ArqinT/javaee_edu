package com.springinaction.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("eddie")
public class Instrumentalist implements Performer {

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    @Autowired(required = false)
    public Instrumentalist(Instrument instrument) {
        this.instrument = instrument;
    }

    public void perform() throws PerformanceException {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }

    private String song;

    public void setSong(String song) {
        // Внедрение мелодии
        this.song = song;

    }

    public String getSong() {
        return song;
    }

    public String screamSong() {
        return song;
    }

    @Autowired(required = false)
    @Qualifier("guitar")
    private Instrument instrument;

    @Autowired
    @Qualifier("guitar")
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}