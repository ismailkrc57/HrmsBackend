package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISchoolDao extends JpaRepository<School,Integer> {
    School findById(int id);
    List<School> getAllByResume_Id(int resumeId);
    List<School> getAllByResume_IdOrderByStartDateDesc(int resumeId);
    boolean existsBySchoolNameAndAndDepartmentAndResume(String schoolName, String department, Resume resume);
}
