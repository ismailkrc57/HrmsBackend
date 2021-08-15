package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dtos.EmployerDto;

import java.util.List;

public interface IEmployerService {
    DataResult<List<Employer>> getAll();
    Result add(EmployerDto employerDto);
    DataResult<Employer> getByMailAndPassword(String mail, String password);
}
