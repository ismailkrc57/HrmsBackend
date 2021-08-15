package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Technology;

import java.util.List;

public interface ITechnologyService {
    DataResult<List<Technology>> getAll();

    Result add(Technology technology);

    DataResult<Technology> findById(int id);

    DataResult<List<Technology>> getAllByResume_Id(int resumeId);

    Result update(int id, String technologyName);

    Result delete(int id);
}
