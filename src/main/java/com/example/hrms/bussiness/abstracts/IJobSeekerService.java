package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface IJobSeekerService {
    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);
    DataResult<JobSeeker> getById(int id);
    DataResult<JobSeeker> getByMailAndPassword(String mail, String password);
    DataResult<JobSeeker> getByNationalityIdAndPassword(String nationalityId, String password);


}