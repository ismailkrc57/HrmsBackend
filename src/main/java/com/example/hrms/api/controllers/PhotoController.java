package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.IPhotoService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Photo;
import com.example.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    IPhotoService iPhotoService;

    @Autowired
    public PhotoController(IPhotoService iPhotoService) {
        this.iPhotoService = iPhotoService;
    }

    @GetMapping("/getAll")
    DataResult<List<Photo>> getAll(){
        return iPhotoService.getAll();
    }


    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody MultipartFile file, @RequestParam int resumeId){
        Photo photo = new Photo();
        Resume resume = new Resume();
        resume.setId(resumeId);
        photo.setResume(resume);
        return ResponseEntity.ok(this.iPhotoService.add(photo,file));

    }

    @GetMapping("/getByResume")
    DataResult<Photo> getByResume(@RequestParam int resumeId){
        return iPhotoService.getByResume_Id(resumeId);
    }

    @DeleteMapping("/delete")
    Result delete(@RequestParam int id){
       return iPhotoService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErorDataResult<Object> errors = new ErorDataResult<>(validationErrors, "Doğrulama hataları");
        return errors;
    }
}
