package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.SystemPersonel;

import java.util.List;

public interface ISystemPersonelService {
    DataResult<List<SystemPersonel>> getAll();
    Result VerifyEmployer(Employer employer);
}
