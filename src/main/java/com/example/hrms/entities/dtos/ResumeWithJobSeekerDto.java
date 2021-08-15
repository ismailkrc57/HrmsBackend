package com.example.hrms.entities.dtos;

import com.example.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResumeWithJobSeekerDto {

    private Resume resume;

    private List<School> school;

    private List<Experience> experiences;

    private List<Technology> technologies;

    private List<Language> languages;


}
