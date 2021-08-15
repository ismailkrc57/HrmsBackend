package com.example.hrms.validations.concretes;

import com.example.hrms.core.utilities.results.ErorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.IJobPositionDao;
import com.example.hrms.entities.concretes.JobPosition;
import org.springframework.stereotype.Service;


@Service
public class JobPositionValidation  {

    public Result CheckIt(JobPosition jobPosition,IJobPositionDao iJobPositionDao) {
        if (!iJobPositionDao.existsByPositionName(jobPosition.getPositionName())) {
            iJobPositionDao.save(jobPosition);
            return new SuccessResult("Job Position added");
        } else return new ErorResult("Position Already exsist");
    }
}
