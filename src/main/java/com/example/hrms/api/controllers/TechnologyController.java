package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.ITechnologyService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Technology;
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
@RequestMapping("/api/technologies")
public class TechnologyController {
    ITechnologyService iTechnologyService;

    @Autowired
    public TechnologyController(ITechnologyService iTechnologyService) {
        this.iTechnologyService = iTechnologyService;
    }

    @GetMapping("/getAll")
    DataResult<List<Technology>> getAll() {

        return iTechnologyService.getAll();
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@Valid @RequestBody Technology technology) {

        return ResponseEntity.ok(iTechnologyService.add(technology));

    }

    @GetMapping("/findById")
    DataResult<Technology> findById(int id) {

        return iTechnologyService.findById(id);
    }

    @GetMapping("/getAllByResume_Id")
    DataResult<List<Technology>> getAllByResume_Id(int resumeId) {

        return iTechnologyService.getAllByResume_Id(resumeId);
    }

    @PostMapping("/update")
    ResponseEntity<?> update(@Valid @RequestParam int id, @Valid @RequestParam String technologyName) {

        return ResponseEntity.ok(iTechnologyService.update(id, technologyName));
    }

    @DeleteMapping("/delete")
    Result delete(int id) {
        return iTechnologyService.delete(id);
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
