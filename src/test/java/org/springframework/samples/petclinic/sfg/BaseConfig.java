package org.springframework.samples.petclinic.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// TODO : 144. JUnit 4 Laurel Test

@Profile("base-test")  //TODO 152
@Configuration
public class BaseConfig {

    //Setting up a Spring Configuration that is going to set up a wordProducer
    @Bean
    HearingInterpreter hearingInterpreter(WordProducer wordProducer) {
        return new HearingInterpreter(wordProducer);
    }

}
