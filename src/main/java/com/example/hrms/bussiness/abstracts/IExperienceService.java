package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Experience;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IExperienceService {
    DataResult<List<Experience>> getAll();
    DataResult<List<Experience>> getAllByResume_Id(int resumeId);
    DataResult<List<Experience>> getAllByResume_IdOrderByStartDateDesc(int resumeId);
    Result add(Experience experience);
    Result delete(int id);
    Result update(int id, String workPlaceName, String positionName, LocalDate startDate,LocalDate finishDate,boolean status);
}
