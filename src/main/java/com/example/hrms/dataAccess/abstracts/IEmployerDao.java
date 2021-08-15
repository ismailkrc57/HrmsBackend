package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployerDao extends JpaRepository<Employer,Integer> {
    boolean existsByMail(String mail);
    Employer getById(Integer id);
    Employer getByMailAndPassword(String mail, String password);
}
