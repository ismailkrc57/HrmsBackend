package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.IExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.IExperienceDao;
import com.example.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ExperienceManager implements IExperienceService {
    private IExperienceDao iExperienceDao;

    @Autowired
    public ExperienceManager(IExperienceDao iExperienceDao) {
        this.iExperienceDao = iExperienceDao;
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<>(iExperienceDao.findAll());
    }

    @Override
    public DataResult<List<Experience>> getAllByResume_Id(int resumeId) {
        return new SuccessDataResult<>(iExperienceDao.getAllByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<Experience>> getAllByResume_IdOrderByStartDateDesc(int resumeId) {
        return new SuccessDataResult<>(iExperienceDao.getAllByResume_IdOrderByStartDateDesc(resumeId));
    }

    @Override
    public Result add(Experience experience) {
        iExperienceDao.save(experience);
        return new SuccessResult("experience added");
    }

    @Override
    public Result delete(int id) {
        iExperienceDao.delete(iExperienceDao.findById(id));
        return new SuccessResult("experience deleted");
    }

    @Override
    public Result update(int id, String workPlaceName, String positionName, LocalDate startDate,LocalDate finishDate,boolean status){
        Experience experience = iExperienceDao.findById(id);
        experience.setWorkPlaceName(workPlaceName);
        experience.setPositionName(positionName);
        experience.setStartDate(startDate);
        experience.setFinishDate(finishDate);
        experience.setStatus(status);
        iExperienceDao.save(experience);
        return new SuccessResult("experience updtaed");
    }


}
