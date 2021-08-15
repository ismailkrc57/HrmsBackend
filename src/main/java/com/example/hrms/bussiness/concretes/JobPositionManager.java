package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.IJobPositionService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.IJobPositionDao;
import com.example.hrms.entities.concretes.JobPosition;
import com.example.hrms.validations.concretes.JobPositionValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements IJobPositionService {
    private IJobPositionDao iJobPositionDao;
    private JobPositionValidation jobPositionValidation;

    @Autowired
    public JobPositionManager(IJobPositionDao iJobPositionDao, JobPositionValidation jobPositionValidation) {
        this.iJobPositionDao = iJobPositionDao;
        this.jobPositionValidation = jobPositionValidation;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(iJobPositionDao.findAll(), "Data listelendi");
    }

    @Override
    public Result add(JobPosition jobPosition) {
        return jobPositionValidation.CheckIt(jobPosition,iJobPositionDao);
    }
}
