package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.concretes.School;

import java.time.LocalDate;
import java.util.List;

public interface ISchoolService {
    DataResult<List<School>> getAll();
    Result add(School school);
    DataResult<List<School>> getAllByResume_Id(int resumeId);
    DataResult<List<School>> getAllByResume_IdOrderByStartDateDesc(int resumeId);
    Result update(int id, String department, LocalDate startDate,LocalDate dateOfGraduation,boolean status);
    Result delete(int id);
}
