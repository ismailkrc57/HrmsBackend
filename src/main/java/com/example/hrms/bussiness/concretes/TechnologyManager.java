package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.ITechnologyService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.ITechnologyDao;
import com.example.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements ITechnologyService {
    ITechnologyDao iTechnologyDao;

    @Autowired
    public TechnologyManager(ITechnologyDao iTechnologyDao) {
        this.iTechnologyDao = iTechnologyDao;
    }

    @Override
    public DataResult<List<Technology>> getAll() {
        return new SuccessDataResult<>(iTechnologyDao.findAll());
    }

    @Override
    public Result add(Technology technology) {
        if (iTechnologyDao.existsByTechnologyNameAndAndResume(technology.getTechnologyName(), technology.getResume()))
            return new ErorResult("already exist same technology");
        else {
            iTechnologyDao.save(technology);

            return new SuccessResult("technology added");
        }

    }

    @Override
    public DataResult<Technology> findById(int id) {
        return new SuccessDataResult<>(iTechnologyDao.findById(id));
    }

    @Override
    public DataResult<List<Technology>> getAllByResume_Id(int resumeId) {
        return new SuccessDataResult<>(iTechnologyDao.getAllByResume_Id(resumeId));
    }


    @Override
    public Result update(int id, String technologyName) {
        Technology technology = iTechnologyDao.findById(id);
        technology.setTechnologyName(technologyName);
        iTechnologyDao.save(technology);
        return new SuccessResult("technology updated");
    }

    @Override
    public Result delete(int id) {
        iTechnologyDao.delete(iTechnologyDao.findById(id));
        return new SuccessResult("technology deleted") ;
    }
}
