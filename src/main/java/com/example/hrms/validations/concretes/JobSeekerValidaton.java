package com.example.hrms.validations.concretes;

import com.example.hrms.adapters.abstracts.AuthService;
import com.example.hrms.adapters.abstracts.UserCheckService;
import com.example.hrms.core.utilities.results.ErorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.IJobSeekerDao;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerValidaton {

    public Result CheckIt(JobSeeker jobSeeker, UserCheckService userCheckService, IJobSeekerDao iJobSeekerDao, AuthService authService) {
            if (jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat())) {
                if (userCheckService.checkIfRealPerson(jobSeeker)) {
                    if (!iJobSeekerDao.existsByNationalityId(jobSeeker.getNationalityId())) {
                        if (!iJobSeekerDao.existsByMail(jobSeeker.getMail())) {
                            try {
                                iJobSeekerDao.save(jobSeeker);
                                return new SuccessResult("Mernis Verifyed, " + authService.verify(jobSeeker.getMail()).getMessage() + ", Job Seeker Aded");
                            } catch (Exception exceptione) {
                                return new ErorResult("please check Entered information");
                            }
                        } else
                            return new ErorResult("E-mail Already Exsit");
                    } else
                        return new ErorResult("Nationality Id Alredy exsit");
                } else
                    return new ErorResult("Not a Valid User");
            } else
                return new ErorResult("passwords do not match ");
    }
}

