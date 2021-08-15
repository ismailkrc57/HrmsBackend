package com.example.hrms.bussiness.concretes;

import com.example.hrms.adapters.abstracts.CloudinaryService;
import com.example.hrms.bussiness.abstracts.IPhotoService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.IPhotoDao;
import com.example.hrms.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class PhotoManager implements IPhotoService {
    CloudinaryService cloudinaryService;
    IPhotoDao iPhotoDao;

    @Autowired
    public PhotoManager(CloudinaryService cloudinaryService, IPhotoDao iPhotoDao) {
        this.cloudinaryService = cloudinaryService;
        this.iPhotoDao = iPhotoDao;
    }

    @Override
    public DataResult<List<Photo>> getAll() {
        return new SuccessDataResult<>(iPhotoDao.findAll());
    }

    @Override
    public Result add(Photo photo, MultipartFile image) {
        Map<String,String> uploadImage =  this.cloudinaryService.uploadImage(image).getData();
        photo.setImageUrl(uploadImage.get("url"));
        this.iPhotoDao.save(photo);
        return new SuccessResult("photo added");
    }

    @Override
    public DataResult<Photo> getByResume_Id(int resumeId) {
        return new SuccessDataResult<>(iPhotoDao.getByResume_Id(resumeId));
    }

    @Override
    public Result delete(int id) {
        iPhotoDao.delete(iPhotoDao.findById(id));
        return new SuccessResult("photo deleted");
    }
}
