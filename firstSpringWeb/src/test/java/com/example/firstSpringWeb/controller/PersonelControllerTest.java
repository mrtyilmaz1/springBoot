package com.example.firstSpringWeb.controller;

import com.example.firstSpringWeb.enums.Department;
import com.example.firstSpringWeb.enums.Gender;
import com.example.firstSpringWeb.model.Personel;
import com.example.firstSpringWeb.service.PersonelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonelControllerTest {

    @InjectMocks
    private PersonelController personelController;

    @Mock
    private PersonelService personelService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void savePersonel() {
        //given
        Personel personel = new Personel();
        personel.setDepartmant(Department.IT);
        personel.setMarried(false);
        personel.setGender(Gender.M);
        personel.setSalary(200D);
        personel.setSurname("java");
        personel.setFirstName("intelij");

        //when
        when(personelService.savePersonel(personel)).thenReturn(personel);

        Personel response = personelController.savePersonel(personel);

        assertEquals(personel.getGender(), response.getGender());
        verify(personelService, Mockito.times(1)).savePersonel(personel);
    }
}
