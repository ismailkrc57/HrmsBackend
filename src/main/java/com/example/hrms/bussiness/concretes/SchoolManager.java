package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.ISchoolService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.ISchoolDao;
import com.example.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SchoolManager implements ISchoolService {
    ISchoolDao iSchoolDao;

    @Autowired
    public SchoolManager(ISchoolDao iSchoolDao) {
        this.iSchoolDao = iSchoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(iSchoolDao.findAll());
    }

    @Override
    public Result add(School school) {
        if (iSchoolDao.existsBySchoolNameAndAndDepartmentAndResume(school.getSchoolName(),
                school.getDepartment(),
                school.getResume()))
            return new ErorResult("already exist in same school name and same department");
        else {
            iSchoolDao.save(school);
            return new SuccessResult("school added");
        }

    }

    @Override
    public DataResult<List<School>> getAllByResume_Id(int resumeId) {
        return new SuccessDataResult<>(iSchoolDao.getAllByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<School>> getAllByResume_IdOrderByStartDateDesc(int resumeId) {
        return new SuccessDataResult<>(iSchoolDao.getAllByResume_IdOrderByStartDateDesc(resumeId));
    }

    @Override
    public Result update(int id, String department, LocalDate startDate, LocalDate dateOfGraduation, boolean status) {
        School school = iSchoolDao.findById(id);
        school.setDepartment(department);
        school.setStartDate(startDate);
        school.setDateOfGraduation(dateOfGraduation);
        school.setStatus(status);
        iSchoolDao.save(school);
        return new SuccessResult("school updated");
    }

    @Override
    public Result delete(int id) {
        iSchoolDao.delete(iSchoolDao.findById(id));
        return new SuccessResult("school deleted");
    }
}
