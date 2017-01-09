package com.springinaction.springidol;

import java.util.Map;
import java.util.Properties;

public class OneManBand implements Performer {
    public OneManBand() {
    }


    public void perform() throws PerformanceException {
        for (Object key : instruments.keySet()) {
            System.out.print(key + " : ");
            System.out.println(instruments.get(key));
        }
    }

    private Properties instruments;

    public void setInstruments(Properties instruments) {
        this.instruments = instruments; }
}