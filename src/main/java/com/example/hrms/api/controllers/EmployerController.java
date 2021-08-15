package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.IEmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dtos.EmployerDto;
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

@RestController
@CrossOrigin
@RequestMapping("/api/employers")
public class EmployerController {
    private IEmployerService iEmployerService;

    @Autowired
    public EmployerController(IEmployerService iEmployerService) {
        this.iEmployerService = iEmployerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return iEmployerService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody EmployerDto employerDto) {
        return ResponseEntity.ok(iEmployerService.add(employerDto));
    }

    @GetMapping("/getByMailAndPassword")
    public DataResult<Employer> getByMailAndPassword(@RequestParam String mail, @RequestParam String password) {
        return iEmployerService.getByMailAndPassword(mail, password);
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
