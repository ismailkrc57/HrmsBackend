package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobPositionDao extends JpaRepository<JobPosition,Integer> {
    boolean existsByPositionName(String positionName);
    JobPosition getById(Integer id);
}
