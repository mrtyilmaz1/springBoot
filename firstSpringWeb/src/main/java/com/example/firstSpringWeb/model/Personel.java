package com.example.firstSpringWeb.model;

import com.example.firstSpringWeb.enums.Department;
import com.example.firstSpringWeb.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "personel")
@Getter
@Setter
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    private String surname;

    private double salary;

    @Column(name = "is_married")
    @JsonProperty("isMarried")
    private boolean isMarried;

    private Department departmant;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
}
