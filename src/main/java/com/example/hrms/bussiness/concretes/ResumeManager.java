package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.*;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.IJobSeekerDao;
import com.example.hrms.dataAccess.abstracts.IResumeDao;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeWithJobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements IResumeService {

    IResumeDao iResumeDao;
    IJobSeekerDao iJobSeekerDao;
    ISchoolService iSchoolService;
    IExperienceService iExperienceService;
    ILanguageService iLanguageService;
    ITechnologyService iTechnologyService;
    IPhotoService iPhotoService;

    @Autowired
    public ResumeManager(IResumeDao iResumeDao, IJobSeekerDao iJobSeekerDao, ISchoolService iSchoolService, IExperienceService iExperienceService, ILanguageService iLanguageService, ITechnologyService iTechnologyService, IPhotoService iPhotoService) {
        this.iResumeDao = iResumeDao;
        this.iJobSeekerDao = iJobSeekerDao;
        this.iSchoolService = iSchoolService;
        this.iExperienceService = iExperienceService;
        this.iLanguageService = iLanguageService;
        this.iTechnologyService = iTechnologyService;
        this.iPhotoService = iPhotoService;
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<>(iResumeDao.findAll());
    }

    @Override
    public Result add(Resume resume) {
        iResumeDao.save(resume);
        return new SuccessResult("resume added");
    }

    @Override
    public DataResult<ResumeWithJobSeekerDto> getResumeWithJobSeeker(int resumeId) {
        ResumeWithJobSeekerDto resumeWithJobSeekerDto = new ResumeWithJobSeekerDto();
        resumeWithJobSeekerDto.setResume(iResumeDao.getById(resumeId));
        resumeWithJobSeekerDto.setSchool(iSchoolService.getAllByResume_Id(resumeId).getData());
        resumeWithJobSeekerDto.setExperiences(iExperienceService.getAllByResume_Id(resumeId).getData());
        resumeWithJobSeekerDto.setTechnologies(iTechnologyService.getAllByResume_Id(resumeId).getData());
        resumeWithJobSeekerDto.setLanguages(iLanguageService.getAllByResume_Id(resumeId).getData());
        return new SuccessDataResult<>(resumeWithJobSeekerDto);

    }
}
