package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface IJobPositionService {
    DataResult<List<JobPosition>>getAll();
    Result add(JobPosition jobPosition);
}