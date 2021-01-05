package org.springframework.samples.petclinic.sfg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// TODO 153. Spring Test Properties


@Component
@Profile({"externalized", "laurel-properties"})  //TODO 155 added laurel-properties
@Primary
public class PropertiesWordProducer implements WordProducer{

    private String word;

    @Value("${say.word}")
    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String getWord() {
        return word;
    }
}
