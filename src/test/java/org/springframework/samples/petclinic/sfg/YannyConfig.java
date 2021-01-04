package org.springframework.samples.petclinic.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

//TODO : 146 Assignment Review

//recap : we created a new Java Configuration Class for Spring with @Configuration
// declared one bean
//We added in a HearingIntepreterYannyTest
//decorated the HearingIntepreterYannyTest with the SpringRunner.class for use with JUnit 4
//On HearingIntepreterYannyTest, we added @ContextConfiguration to tell the spring context to
//use the BaseConfig.class and the YannyConfig.class
//We autowired the HearingInterpreter into our class and did an assertion on whatIheard()
//   and verified that it did get "Yanny" back.

@Configuration
public class YannyConfig {



    @Bean
    YannyWordProducer yannyWordProducer() {
        return new YannyWordProducer();
    }

}
