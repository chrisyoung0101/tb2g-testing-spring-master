package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

//TODO : 151. Using Component Scans

//Note : because LaurelWordProducer has @Primary, this is the one that will
//  get brought into our test context

@SpringJUnitConfig(classes = HearingInterpreterComponentScanTest.TestConfig.class)
class HearingInterpreterComponentScanTest {

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

            assertEquals("Laurel", word);
        }


}