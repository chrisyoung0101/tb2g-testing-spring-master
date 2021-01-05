package org.springframework.samples.petclinic.sfg;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

// TODO 144. JUnit 4 Laurel Test


@ActiveProfiles("base-test")  //TODO 152
//tells the test that we want to run with the springrunner which brings up the spring context.
@RunWith(SpringRunner.class)  // Spring Framework & not Boot
//spring looks at these two config classes
//spring will build spring context
//On test execution, it will autowire a HearingInterpreter that has the Laurel Bean injected into it.
@ContextConfiguration(classes = {BaseConfig.class, LaurelConfig.class})
public class HearingInterpreterTest { //This is the consumer class

    @Autowired
    HearingInterpreter hearingInterpreter;


    //removed because we will have the Spring Context manage this
//    @Before
//    public void setUp() throws Exception {
//        hearingInterpreter = new HearingInterpreter(new LaurelWordProducer());
//    }

    @Test
    public void whatIheard() {
        String word = hearingInterpreter.whatIheard();

        assertEquals("Laurel", word);
    }
}