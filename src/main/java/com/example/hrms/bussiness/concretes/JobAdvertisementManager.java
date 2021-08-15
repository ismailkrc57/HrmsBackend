package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.IJobAdvertisementService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.IJobAdvertisementDao;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.AdvertisementWithCompanyAndPositionDto;
import com.example.hrms.validations.concretes.JobAdvertisementValidaton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements IJobAdvertisementService {
    private final IJobAdvertisementDao iJobAdvertisementDao;
    private final JobAdvertisementValidaton jobAdvertisementValidaton;

    @Autowired
    public JobAdvertisementManager(IJobAdvertisementDao iJobAdvertisementDao, JobAdvertisementValidaton jobAdvertisementValidaton) {
        this.iJobAdvertisementDao = iJobAdvertisementDao;
        this.jobAdvertisementValidaton = jobAdvertisementValidaton;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getALl() {
        return new SuccessDataResult(iJobAdvertisementDao.findAll(), "All of job advertisements listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getALlSortedByDeadlineASC() {
        return new SuccessDataResult<>(iJobAdvertisementDao.getAllByIsActiveTrueOrderByDeadlineAsc(), "all of active jobs listed ASC by deadline");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getALlSortedByDeadlineDESC() {
        return new SuccessDataResult<>(iJobAdvertisementDao.getAllByIsActiveTrueOrderByDeadlineDesc(), "all of active jobs listed DESC by deadline");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getALlSortedByRelaseDateASC() {
        return new SuccessDataResult<>(iJobAdvertisementDao.getAllByIsActiveTrueOrderByRelaseDateAsc(), "all of deactive jobs listed ASC by relase date");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getALlSortedByRelaseDateDESC() {
        return new SuccessDataResult<>(iJobAdvertisementDao.getAllByIsActiveTrueOrderByRelaseDateDesc(), "all of deactive jobs listed DESC by relase date");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementValidaton.checkIt(jobAdvertisement, iJobAdvertisementDao);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(iJobAdvertisementDao.getAllByIsActiveTrue(), "active job advertisements listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByActiveFalse() {
        return new SuccessDataResult<>(iJobAdvertisementDao.getAllByIsActiveFalse(), "deactive job advertisements listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByActiveTrueAndEmployerEmployer_Id(Integer id) {
        return new SuccessDataResult<>(iJobAdvertisementDao.getAllByIsActiveTrueAndEmployer_Id(id),"Data listed");
    }

    @Override
    public Result setActivity(Integer id, boolean bool) {
        JobAdvertisement jobAdvertisement = iJobAdvertisementDao.getById(id);
        jobAdvertisement.setActive(bool);
        iJobAdvertisementDao.save(jobAdvertisement);
        return (bool == true ? new SuccessResult("job advertisement has been activated") : new SuccessResult("job advertisement has been deactivated"));
    }

    @Override
    public DataResult<List<AdvertisementWithCompanyAndPositionDto>> getAdvertisementWithCompanyAndPositionDetails(int employerId) {
        return new SuccessDataResult<>(iJobAdvertisementDao.getAdvertisementWithCompanyAndPositionDetails(employerId),"Data Listed");
    }
}
