package com.example.hrms.adapters.abstracts;

import com.example.hrms.entities.concretes.JobSeeker;
import com.example.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;


public interface UserCheckService {
    Boolean checkIfRealPerson(JobSeeker jobSeeker);
}
