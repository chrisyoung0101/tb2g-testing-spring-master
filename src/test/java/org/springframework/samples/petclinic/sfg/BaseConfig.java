package org.springframework.samples.petclinic.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO : 144. JUnit 4 Laurel Test

@Configuration
public class BaseConfig {

    //Setting up a Spring Configuration that is going to set up a wordProducer
    @Bean
    HearingInterpreter hearingInterpreter(WordProducer wordProducer) {
        return new HearingInterpreter(wordProducer);
    }

}
