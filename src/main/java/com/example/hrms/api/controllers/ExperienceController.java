package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.IExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Experience;
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
@RequestMapping("/api/Experiences")
public class ExperienceController {
    private IExperienceService iExperienceService;

    @Autowired
    public ExperienceController(IExperienceService iExperienceService) {
        this.iExperienceService = iExperienceService;
    }

    @GetMapping("/getall")
    public DataResult<List<Experience>> getAll() {
        return iExperienceService.getAll();
    }

    @GetMapping("/getAllByResume_Id")
    DataResult<List<Experience>> getAllByResume_Id(@RequestParam int resumeId) {
        return iExperienceService.getAllByResume_Id(resumeId);
    }

    @GetMapping("/getAllByResume_IdOrderByStartDateDesc")
    DataResult<List<Experience>> getAllByResume_IdOrderByStartDateDesc(@RequestParam int resumeId) {
        return iExperienceService.getAllByResume_IdOrderByStartDateDesc(resumeId);
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@Valid @RequestBody Experience experience) {
        return ResponseEntity.ok(iExperienceService.add(experience));
    }

    @DeleteMapping("/delete")
    Result delete(@RequestParam int id)
    {
        return iExperienceService.delete(id);
    }

    @PostMapping("/update")
    public ResponseEntity<?> Update(@Valid @RequestParam int id, String workPlaceName, String positionName,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishDate,
                                    boolean status) {
        return ResponseEntity.ok(iExperienceService.update(id, workPlaceName, positionName, startDate,finishDate,status));
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
