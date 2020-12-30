package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

// TODO : Assignment Review
@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    ClinicService clinicService;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    VetController controller;

    //Set up a class level property
    List<Vet> vetsList = new ArrayList<>();

    //If we did not use this @BeforeEach then we would
    // need to add both lines of code into each of our two tests
    @BeforeEach
    void setUp() {

        //initialize this class level property
        vetsList.add(new Vet());

        //Think this initializes our two mocks
        given(clinicService.findVets()).willReturn(vetsList);


    }

    @Test
    void showVetList() {
        //when
        String view = controller.showVetList(model);


        //then
        then(clinicService).should().findVets();
        then(model).should().put(anyString(), any());
            //verifies the view is coming back properly
        assertThat("vets/VetList").isEqualToIgnoringCase(view);


    }

    @Test
    void showResourcesVetList() {
        //when
        Vets vets = controller.showResourcesVetList();



        //then
        then(clinicService).should().findVets();
        assertThat(vets.getVetList()).hasSize(1);

    }
}