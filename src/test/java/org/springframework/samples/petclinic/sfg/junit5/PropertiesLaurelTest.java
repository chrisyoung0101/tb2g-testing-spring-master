package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO 155. Assignment Review

//Note : for a recap, see 154 @ 3:15


@TestPropertySource("classpath:laurel.properties")
@ActiveProfiles("laurel-properties")
@SpringJUnitConfig(classes = PropertiesLaurelTest.TestConfig.class)
public class PropertiesLaurelTest {
    @Configuration
    //tells this test to use this inner class to go out and do a component scan
    //  and pick up the spring framework annotations we added to the classes
    @ComponentScan("org.springframework.samples.petclinic.sfg")
    static class TestConfig {

    }

    @Autowired
    HearingInterpreter hearingInterpreter;


    @Test
    void whatIheard() {
        String word = hearingInterpreter.whatIheard();
        //funky spelling to insure that YaNNy value is coming from yanny.properties
        assertEquals("LAUrel", word);
    }

}
