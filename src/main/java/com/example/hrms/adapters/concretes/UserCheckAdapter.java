package com.example.hrms.adapters.concretes;

import com.example.hrms.adapters.abstracts.UserCheckService;
import com.example.hrms.entities.concretes.JobSeeker;
import com.example.hrms.mernis.TVHKPSPublicSoap;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserCheckAdapter implements UserCheckService {
    private TVHKPSPublicSoap tvhkpsPublicSoap = new TVHKPSPublicSoap();


    @Override
    public Boolean checkIfRealPerson(JobSeeker jobSeeker)  {
        try {
            return tvhkpsPublicSoap.TCKimlikNoDogrula(Long.valueOf(jobSeeker.getNationalityId()),jobSeeker.getName(), jobSeeker.getSurname(), jobSeeker.getBirthDay().getYear());
        } catch (Exception exception) {
            return false;
        }
    }
}
