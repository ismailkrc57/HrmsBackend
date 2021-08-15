package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeWithJobSeekerDto;

import java.util.List;

public interface IResumeService {
    DataResult<List<Resume>> getAll();
    Result add(Resume resume);
    DataResult<ResumeWithJobSeekerDto> getResumeWithJobSeeker(int resumeId);
}
