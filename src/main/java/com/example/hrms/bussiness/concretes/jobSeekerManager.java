package com.example.hrms.bussiness.concretes;

import com.example.hrms.adapters.abstracts.AuthService;
import com.example.hrms.adapters.abstracts.UserCheckService;
import com.example.hrms.adapters.concretes.FakeUserCheckAdapter;
import com.example.hrms.bussiness.abstracts.IJobSeekerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.IJobSeekerDao;
import com.example.hrms.entities.concretes.JobSeeker;
import com.example.hrms.validations.concretes.JobSeekerValidaton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jobSeekerManager implements IJobSeekerService {
    private IJobSeekerDao iJobSeekerDao;
    private UserCheckService userCheckService;
    private AuthService authService;
    private JobSeekerValidaton jobSeekerValidaton;


    @Autowired
    public jobSeekerManager(IJobSeekerDao iJobSeekerDao, FakeUserCheckAdapter userCheckService, AuthService authService, JobSeekerValidaton jobSeekerValidaton) {
        this.iJobSeekerDao = iJobSeekerDao;
        this.userCheckService = userCheckService;
        this.authService = authService;
        this.jobSeekerValidaton = jobSeekerValidaton;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(iJobSeekerDao.findAll(), "Data listelendi");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        return jobSeekerValidaton.CheckIt(jobSeeker, userCheckService, iJobSeekerDao, authService);
    }

    @Override
    public DataResult<JobSeeker> getById(int id) {
        if (iJobSeekerDao.findById(id) == null)
            return new ErorDataResult<>("user can not find");
        else
            return new SuccessDataResult<>(iJobSeekerDao.findById(id));
    }

    @Override
    public DataResult<JobSeeker> getByMailAndPassword(String mail, String password) {
        if (iJobSeekerDao.findByMailAndPassword(mail, password) == null)
            return new ErorDataResult<>("user can not find");
        else
            return new SuccessDataResult<>(iJobSeekerDao.getByMailAndPassword(mail, password));
    }

    @Override
    public DataResult<JobSeeker> getByNationalityIdAndPassword(String nationalityId, String password) {
        if (iJobSeekerDao.getByNationalityIdAndPassword(nationalityId, password) == null)
            return new ErorDataResult<>("user can not find");
        else
            return new SuccessDataResult<>(iJobSeekerDao.getByNationalityIdAndPassword(nationalityId, password));
    }

}


