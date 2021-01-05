package org.springframework.samples.petclinic.sfg;

//TODO 143

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//TODO 152
//removed for 152 --> @Primary  // LaurelWordProducer & YannyWordProducer are similar components.
// @Primary here makes LaurelWordProducer the default bean.
public class LaurelWordProducer implements WordProducer{


    @Override
    public String getWord() {
        return "Laurel";
    }
}
