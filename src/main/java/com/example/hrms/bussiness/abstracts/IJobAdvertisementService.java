package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.AdvertisementWithCompanyAndPositionDto;

import java.util.List;


public interface IJobAdvertisementService {
    DataResult<List<JobAdvertisement>> getALl();
    DataResult<List<JobAdvertisement>> getALlSortedByDeadlineASC();
    DataResult<List<JobAdvertisement>> getALlSortedByDeadlineDESC();
    DataResult<List<JobAdvertisement>> getALlSortedByRelaseDateASC();
    DataResult<List<JobAdvertisement>> getALlSortedByRelaseDateDESC();
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAllByActiveTrue();
    DataResult<List<JobAdvertisement>> getAllByActiveFalse();
    DataResult<List<JobAdvertisement>> getAllByActiveTrueAndEmployerEmployer_Id(Integer id);
    Result setActivity(Integer id,boolean bool);
    DataResult<List<AdvertisementWithCompanyAndPositionDto>> getAdvertisementWithCompanyAndPositionDetails(int employerId);
}
