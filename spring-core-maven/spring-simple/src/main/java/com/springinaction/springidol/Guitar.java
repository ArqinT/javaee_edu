package com.springinaction.springidol;

import com.springinaction.springidol.qualifiers.StringedInstrument;
import org.springframework.stereotype.Component;

/**
 * Created by artemtursunov on 25.12.16.
 */
@Component
@StringedInstrument
public class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("DRING DRING DRING");
    }
}
