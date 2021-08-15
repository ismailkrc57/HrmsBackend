package com.example.hrms.bussiness.concretes;

import com.example.hrms.adapters.abstracts.AuthService;
import com.example.hrms.bussiness.abstracts.IEmployerService;
import com.example.hrms.bussiness.abstracts.ISystemPersonelService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.IEmployerDao;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dtos.EmployerDto;
import com.example.hrms.validations.concretes.EmployerValidaton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements IEmployerService {
    private IEmployerDao iEmployerDao;
    private AuthService authService;
    private ISystemPersonelService iSystemPersonelService;
    private EmployerValidaton employerValidaton;

    @Autowired
    public EmployerManager(IEmployerDao iEmployerDao, AuthService authService, ISystemPersonelService iSystemPersonelService, EmployerValidaton employerValidaton) {
        this.iEmployerDao = iEmployerDao;
        this.authService = authService;
        this.iSystemPersonelService = iSystemPersonelService;
        this.employerValidaton = employerValidaton;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(iEmployerDao.findAll(), "Data listelendi");
    }


    @Override
    public Result add(EmployerDto employerDto) {

        return employerValidaton.CheckIt(employerDto,iEmployerDao,iSystemPersonelService,authService);
    }

    @Override
    public DataResult<Employer> getByMailAndPassword(String mail, String password) {
        if (iEmployerDao.getByMailAndPassword(mail,password)==null)
            return new ErorDataResult<>("Compnay could not find");
        else
            return new SuccessDataResult<>(iEmployerDao.getByMailAndPassword(mail,password));
    }
}

