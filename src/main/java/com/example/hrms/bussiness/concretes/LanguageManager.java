package com.example.hrms.bussiness.concretes;

import com.example.hrms.bussiness.abstracts.ILanguageService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.ILanguageDao;
import com.example.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements ILanguageService {

    ILanguageDao iLanguageDao;

    @Autowired
    public LanguageManager(ILanguageDao iLanguageDao) {
        this.iLanguageDao = iLanguageDao;
    }

    @Override
    public Result add(Language language) {
        if (iLanguageDao.existsByLanguageNameAndResume(language.getLanguageName(), language.getResume()))
            return new ErorResult("already exist same language name");
        else {
            iLanguageDao.save(language);
            return new SuccessResult("language added");
        }


    }

    @Override
    public DataResult<Language> findById(int id) {
        return new SuccessDataResult(iLanguageDao.findById(id));
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult(iLanguageDao.findAll());
    }

    @Override
    public DataResult<List<Language>> getAllByResume_Id(int resumeId) {
        return new SuccessDataResult<>(iLanguageDao.getAllByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<Language>> getAllByResume_IdOrderBylOrderByLevelDesc(int resumeId) {
        return new SuccessDataResult<>(iLanguageDao.getAllByResume_IdOrderByLevelDesc(resumeId));
    }

    @Override
    public Result update(int id, int level) {
        Language language = iLanguageDao.findById(id);
        language.setLevel(level);
        iLanguageDao.save(language);
        return new SuccessResult("Language updated");
    }

    @Override
    public Result delete(int id) {
        iLanguageDao.delete(iLanguageDao.findById(id));
        return new SuccessResult("language deleted");
    }
}
