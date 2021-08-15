package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILanguageDao extends JpaRepository<Language,Integer> {
    Language findById(int id);
    List<Language> getAllByResume_Id(int resumeId);
    List<Language> getAllByResume_IdOrderByLevelDesc(int resumeId);
    boolean existsByLanguageNameAndResume(String languageName, Resume resume);
    Language findByLanguageNameAndResume_Id(String languageName,int resumeId);
}
