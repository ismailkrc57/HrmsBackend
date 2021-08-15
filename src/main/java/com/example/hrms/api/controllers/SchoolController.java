package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.ISchoolService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    ISchoolService iSchoolService;

    @Autowired
    public SchoolController(ISchoolService iSchoolService) {
        this.iSchoolService = iSchoolService;
    }


    @GetMapping("/getall")
    DataResult<List<School>> getAll() {
        return iSchoolService.getAll();
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@Valid @RequestBody School school) {
        return ResponseEntity.ok(iSchoolService.add(school));
    }

    @GetMapping("/getAllByResume_Id")
    DataResult<List<School>> getAllByResume_Id(int resumeId) {
        return iSchoolService.getAllByResume_Id(resumeId);
    }

    @GetMapping("/getAllByResume_IdOrderByStartDateDesc")
    DataResult<List<School>> getAllByResume_IdOrderByStartDateDesc(int resumeId) {
        return iSchoolService.getAllByResume_IdOrderByStartDateDesc(resumeId);
    }

    @PostMapping("/update")
    ResponseEntity<?> update(@Valid @RequestParam int id, @Valid @RequestParam String department,
                             @Valid @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             @Valid @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfGraduation,
                             @Valid @RequestParam boolean status) {
        return ResponseEntity.ok(iSchoolService.update(id, department, startDate, dateOfGraduation, status));
    }

    @DeleteMapping("/delete")
    Result delete(@RequestParam int id) {
        return iSchoolService.delete(id);
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
