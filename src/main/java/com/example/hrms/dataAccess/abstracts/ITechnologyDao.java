package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITechnologyDao extends JpaRepository<Technology, Integer> {
    Technology findById(int id);

    List<Technology> getAllByResume_Id(int resumeId);

    boolean existsByTechnologyNameAndAndResume(String technologyName, Resume resume);
}
