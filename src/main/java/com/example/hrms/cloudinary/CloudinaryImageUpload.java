package com.example.hrms.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public class CloudinaryImageUpload {

    public Map uploadImage(MultipartFile image, Cloudinary cloudinary)
    {
        try {
            return cloudinary.uploader().upload(image.getBytes(),ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
