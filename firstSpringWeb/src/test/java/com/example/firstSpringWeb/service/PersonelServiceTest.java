package com.example.firstSpringWeb.service;

import com.example.firstSpringWeb.enums.Department;
import com.example.firstSpringWeb.enums.Gender;
import com.example.firstSpringWeb.model.Personel;
import com.example.firstSpringWeb.repository.PersonelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PersonelServiceTest {

    @InjectMocks
    private PersonelService personelService;

    @Mock
    private PersonelRepository personelRepository;

    Personel personel;

    @BeforeEach

    public void setup() {
        MockitoAnnotations.initMocks(this);
        personel = new Personel();
        personel.setId(1L);
        personel.setDepartmant(Department.IT);
        personel.setMarried(false);
        personel.setGender(Gender.M);
        personel.setSalary(200D);
        personel.setSurname("adam");
        personel.setFirstName("Bilge");
    }


    @Test
    public void getPersonel_with_id_successsful() {

        //given
        Long id = 1L;

        //then
        String result = personelService.getPersonel(id);

        //assert

        assertEquals("Personel bulundu", result);
    }

    @Test
    public void getPersonel_with_null_id_throw_error_fail() {
        Exception thrown = Assertions.assertThrows(RuntimeException.class,
                () -> personelService.getPersonel(null));

        assertEquals("personel bulunamadı", thrown.getMessage());
    }

    @Test
    public void savePersonel_test_successful() {
        Personel savePersonel = new Personel();

        personel.setDepartmant(Department.IT);
        personel.setMarried(false);
        personel.setGender(Gender.M);
        personel.setSalary(200D);
        personel.setSurname("adam");
        personel.setFirstName("Bilge");

        when(personelRepository.save(any())).thenReturn(personel);
        Personel result = personelService.savePersonel(savePersonel);
        System.out.println();
        assertEquals(personel.getGender(), result.getGender());


    }

    @Test
    public void getPersonelList_test_successful() {
        //given

        //then
        when(personelRepository.findAll()).thenReturn(Arrays.asList(personel));

        //then
        List<Personel> result = personelService.getPersonelList();

        //assert
        assertEquals(1, result.size());
        assertEquals(personel.getId(), result.get(0).getId());
        verify(personelRepository, Mockito.times(1)).findAll();
    }



}
