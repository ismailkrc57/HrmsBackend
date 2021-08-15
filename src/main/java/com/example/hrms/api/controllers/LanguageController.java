package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.ILanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Language;
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
@RequestMapping("/api/Languages")
public class LanguageController {
    ILanguageService iLanguageService;

    @Autowired
    public LanguageController(ILanguageService iLanguageService) {
        this.iLanguageService = iLanguageService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Language language) {
        return ResponseEntity.ok(iLanguageService.add(language));
    }

    @GetMapping("/findById")
    public DataResult<Language> findById(@RequestParam int id) {
        return iLanguageService.findById(id);
    }

    @GetMapping("/getAll")
    DataResult<List<Language>> getAll() {
        return iLanguageService.getAll();
    }

    @GetMapping("/getAllByResume_Id")
    DataResult<List<Language>> getAllByResume_Id(@RequestParam int resumeId) {
        return iLanguageService.getAllByResume_Id(resumeId);
    }

    @GetMapping("/getAllByResume_IdOrderBylOrderByLevelDesc")
    DataResult<List<Language>> getAllByResume_IdOrderBylOrderByLevelDesc(@RequestParam int resumeId) {
        return iLanguageService.getAllByResume_IdOrderBylOrderByLevelDesc(resumeId);
    }

    @PostMapping("update")
    ResponseEntity<?> update(@Valid @RequestParam int id, @Valid @RequestParam int level) {

        return ResponseEntity.ok(iLanguageService.update(id, level));
    }

    @DeleteMapping("delete")
    Result delete(int id) {
        return iLanguageService.delete(id);
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
