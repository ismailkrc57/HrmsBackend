package com.example.hrms.adapters.concretes;

import com.example.hrms.adapters.abstracts.UserCheckService;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class FakeUserCheckAdapter implements UserCheckService {
    @Override
    public Boolean checkIfRealPerson(JobSeeker jobSeeker) {
        return jobSeeker.getNationalityId().length()==11;
    }
}
