package org.springframework.samples.petclinic.sfg;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//TODO 143


@Profile("yanny")    //TODO : 152
@Primary   // TODO : 152
@Component
public class YannyWordProducer implements WordProducer{
    @Override
    public String getWord() {
        return "Yanny";
    }
}
