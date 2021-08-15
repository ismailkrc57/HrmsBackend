package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Experience;
import com.example.hrms.entities.concretes.Language;

import java.util.List;

public interface ILanguageService {
    Result add(Language language);
    DataResult<Language> findById(int id);
    DataResult<List<Language>> getAll();
    DataResult<List<Language>> getAllByResume_Id(int resumeId);
    DataResult<List<Language>> getAllByResume_IdOrderBylOrderByLevelDesc(int resumeId);
    Result update(int id, int level);
    Result delete(int id);
}
