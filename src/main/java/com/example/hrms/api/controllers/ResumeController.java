package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.IResumeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeWithJobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
    IResumeService iResumeService;

    @Autowired
    public ResumeController(IResumeService iResumeService) {
        this.iResumeService = iResumeService;
    }

    @GetMapping("getall")
    DataResult<List<Resume>> getAll() {
        return iResumeService.getAll();
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@Valid @RequestBody Resume resume) {
        return ResponseEntity.ok(iResumeService.add(resume));
    }

    @GetMapping("/getResumeWithJobSeeker")
    DataResult<ResumeWithJobSeekerDto> getResumeWithJobSeeker(@RequestParam int jobSeekrId)
    {
        return iResumeService.getResumeWithJobSeeker(jobSeekrId);
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
