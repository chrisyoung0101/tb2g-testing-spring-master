package org.springframework.samples.petclinic.sfg;
import org.springframework.stereotype.Component;

//TODO 143

@Component
public class YannyWordProducer implements WordProducer{
    @Override
    public String getWord() {
        return "Yanny";
    }
}
