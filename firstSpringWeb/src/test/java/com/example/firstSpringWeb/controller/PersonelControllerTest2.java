package com.example.firstSpringWeb.controller;

import com.example.firstSpringWeb.enums.Department;
import com.example.firstSpringWeb.enums.Gender;
import com.example.firstSpringWeb.model.Personel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.google.gson.Gson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonelControllerTest2 {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void savePersonel_test_successful() throws Exception {
        //given
        Personel personel = new Personel();
        personel.setDepartmant(Department.IT);
        personel.setMarried(false);
        personel.setGender(Gender.M);
        personel.setSalary(200D);
        personel.setSurname("java");
        personel.setFirstName("intelij");

        //then
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/personel/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personel)))
                .andExpect(status().isOk())
                .andReturn();

        Personel response = new Gson().fromJson(mvcResult.getResponse().getContentAsString(), Personel.class);
        assertEquals(Gender.F, response.getGender());
        assertEquals(personel.isMarried(), response.isMarried());
        System.out.println();
    }


}
