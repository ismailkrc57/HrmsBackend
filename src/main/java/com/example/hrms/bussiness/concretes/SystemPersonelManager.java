package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.ISystemPersonelService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.ISystemPersonelDao;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.SystemPersonel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPersonelManager implements ISystemPersonelService {

    private ISystemPersonelDao iSystemPersonelDao;


    @Autowired
    public SystemPersonelManager(ISystemPersonelDao iSystemPersonelDao) {
        this.iSystemPersonelDao = iSystemPersonelDao;
    }

    @Override
    public DataResult<List<SystemPersonel>> getAll() {
        return new SuccessDataResult<>(iSystemPersonelDao.findAll(),"Data listelendi");
    }

    @Override
    public Result VerifyEmployer(Employer employer) {
            return new SuccessResult("Verifyed by System personel");
    }
}
