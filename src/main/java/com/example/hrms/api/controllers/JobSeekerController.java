package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.IJobSeekerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.entities.concretes.JobSeeker;
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
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
    private IJobSeekerService iJobSeekerService;

    @Autowired
    public JobSeekerController(IJobSeekerService iJobSeekerService) {
        this.iJobSeekerService = iJobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {
        return iJobSeekerService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
        return ResponseEntity.ok(iJobSeekerService.add(jobSeeker));
    }

    @GetMapping("/getById")
    public DataResult<JobSeeker> getById(@RequestParam int id) {
        return iJobSeekerService.getById(id);
    }

    @GetMapping("/getByMailAndPassword")
    public DataResult<JobSeeker> getByMailAndPassword(@RequestParam String mail, @RequestParam String password) {
        return iJobSeekerService.getByMailAndPassword(mail, password);
    }
    @GetMapping("/getByNationalityIdAndPassword")
    public DataResult<JobSeeker> getByNationalityIdAndPassword(@RequestParam String nationalityId, @RequestParam String password) {
        return iJobSeekerService.getByNationalityIdAndPassword(nationalityId, password);
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
