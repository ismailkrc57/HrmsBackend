package com.example.hrms.validations.concretes;

import com.example.hrms.core.utilities.results.ErorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.IJobAdvertisementDao;
import com.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class JobAdvertisementValidaton {

    public Result checkIt(JobAdvertisement jobAdvertisement, IJobAdvertisementDao iJobAdvertisementDao) {
        if (jobAdvertisement.getDeadline().isBefore(LocalDate.now())) {
            return new ErorResult("not a valid deadline  please check it");
        } else {
            jobAdvertisement.setActive(true);
            jobAdvertisement.setRelaseDate(LocalDate.now());
            iJobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("job advertisement added");
        }
    }
}
