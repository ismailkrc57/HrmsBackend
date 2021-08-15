package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    boolean existsByNationalityId(String nationalityId);
    boolean existsByMail(String mail);
    JobSeeker findById(int id);
    JobSeeker findByMailAndPassword(String mail, String password);
    JobSeeker getByMailAndPassword(String mail, String password);
    JobSeeker getByNationalityIdAndPassword(String nationalityId, String password);

}
