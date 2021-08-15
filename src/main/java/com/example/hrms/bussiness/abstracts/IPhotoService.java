package com.example.hrms.bussiness.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPhotoService {
    DataResult<List<Photo>> getAll();
    Result add(Photo photo, MultipartFile image);
    DataResult<Photo> getByResume_Id(int resumeId);
    Result delete(int id);
}
