package com.example.hrms.adapters.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryService {
       DataResult<Map> uploadImage(MultipartFile image);
}
