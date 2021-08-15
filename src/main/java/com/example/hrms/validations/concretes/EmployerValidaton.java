package com.example.hrms.validations.concretes;

import com.example.hrms.adapters.abstracts.AuthService;
import com.example.hrms.bussiness.abstracts.ISystemPersonelService;
import com.example.hrms.core.utilities.results.ErorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.IEmployerDao;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dtos.EmployerDto;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerValidaton {
    public Result CheckIt(EmployerDto employerDto, IEmployerDao iEmployerDao, ISystemPersonelService iSystemPersonelService, AuthService authService) {
        Pattern mailPatern = Pattern.compile("[a-z A-Z 0-9]+@[a-z A-Z 0-9]+\\.[a-z A-Z 0-9]+$");
        Matcher mailmatcher = mailPatern.matcher(employerDto.getMail());
        String[] domainsWebsite = employerDto.getWebSite().split("[.]+");
        String[] domainsMail = employerDto.getMail().split("[.]+");

        if (employerDto.getPassword().equals(employerDto.getPasswordRepeat())) {
            if (mailmatcher.matches()) {
                if (domainsMail[domainsMail.length - 1].equals(domainsWebsite[domainsWebsite.length - 1])) {
                    if (!iEmployerDao.existsByMail(employerDto.getMail())) {
                        try {
                            Employer employer = new Employer();
                            employer.setMail(employerDto.getMail());
                            employer.setCompanyName(employerDto.getCompanyName());
                            employer.setPassword(employerDto.getPassword());
                            employer.setPasswordRepeat(employerDto.getPasswordRepeat());
                            employer.setPhoneNumber(employerDto.getPhoneNumber());
                            employer.setWebSite(employerDto.getWebSite());
                            iEmployerDao.save(employer);
                            return new SuccessResult(authService.verify(employerDto.getMail()).getMessage() + ", " +
                                    iSystemPersonelService.VerifyEmployer(employer).getMessage() + ", Employers Added");
                        } catch (Exception e) {
                            return new ErorResult("please check Entered information");
                        }
                    } else
                        return new ErorResult("E-mail Already Exsist");
                } else return new ErorResult("The domain name of the email and the website  must be the same ");

            } else
                return new ErorResult("E-mail format is nat valid plesase ceheck");
        } else
            return new ErorResult("Passwords Do not matches ");
    }
}
