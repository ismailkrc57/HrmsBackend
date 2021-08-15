package com.example.hrms.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.adapters.abstracts.CloudinaryService;
import com.example.hrms.cloudinary.CloudinaryImageUpload;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryImageUploadAdapter implements CloudinaryService {

    private CloudinaryImageUpload cloudinaryImageUpload;
    private Cloudinary cloudinary;

    public CloudinaryImageUploadAdapter() {
        this.cloudinaryImageUpload = new CloudinaryImageUpload();

        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dp1yugjn4",
                "api_key", "737629351212119",
                "api_secret", "RKI6WkSG4ohV-kA5f6kyJH2-XIE"));
    }


    @Override
    public DataResult<Map> uploadImage(MultipartFile image) {

        if (cloudinaryImageUpload.uploadImage(image, cloudinary) != null)
            return new SuccessDataResult<>(cloudinaryImageUpload.uploadImage(image, cloudinary));
        else return new ErorDataResult();

    }
}