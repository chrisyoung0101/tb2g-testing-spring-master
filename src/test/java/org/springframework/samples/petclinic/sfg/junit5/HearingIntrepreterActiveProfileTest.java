package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Recap Note for 152 :
//We change the YannyWordProducer to have a profile of yanny. Marked it as primary because the
//  // LaurelWordProducer does not have a profile.
//YannyWordProducer will only be loaded when the loaded profile is active
//In HearingIntrepreterActiveProfileTest, we are saying with @ActiveProfile("yanny") set the yanny
// // profile active
//For the other test classes, we went in and marked their config with @Profile allowing the configs to be
// // profile specific while at the same time using @ActiveProfiles() to set up the appropriate active profile


//TODO : 152. Setting Active Profile Tests

// Config here is setup to be working with yanny so this is why we switched the @Primary
// on LaurelWordProducer to YannyWordProducer

@ActiveProfiles("yanny")
@SpringJUnitConfig(classes = HearingIntrepreterActiveProfileTest.TestConfig.class)
public class HearingIntrepreterActiveProfileTest {

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

        assertEquals("Yanny", word);
    }

}
