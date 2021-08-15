package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.IJobAdvertisementService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.AdvertisementWithCompanyAndPositionDto;
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
@RequestMapping("/api/JobAdvertisements")
public class JobAdvertisementController {
    private final IJobAdvertisementService iJobAdvertisementService;

    @Autowired
    public JobAdvertisementController(IJobAdvertisementService iJobAdvertisementService) {
        this.iJobAdvertisementService = iJobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.iJobAdvertisementService.getALl();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
        return ResponseEntity.ok(iJobAdvertisementService.add(jobAdvertisement));
    }

    @GetMapping("/getAllByActiveTrue")
    public DataResult<List<JobAdvertisement>> getAllByActiveTrue() {
        return iJobAdvertisementService.getAllByActiveTrue();
    }

    @GetMapping("/getAllByActiveFalse")
    public DataResult<List<JobAdvertisement>> getAllByActiveFalse() {
        return iJobAdvertisementService.getAllByActiveFalse();
    }

    @GetMapping("/getALlSortedByDeadlineASC")
    public DataResult<List<JobAdvertisement>> getALlSortedByDeadlineASC() {
        return iJobAdvertisementService.getALlSortedByDeadlineASC();
    }

    @GetMapping("/getALlSortedByDeadlineDESC")
    public DataResult<List<JobAdvertisement>> getALlSortedByDeadlineDESC() {
        return iJobAdvertisementService.getALlSortedByDeadlineDESC();
    }

    @GetMapping("/getALlSortedByRelaseDateASC")
    public DataResult<List<JobAdvertisement>> getALlSortedByRelaseDateASC() {
        return iJobAdvertisementService.getALlSortedByRelaseDateASC();
    }

    @GetMapping("/getALlSortedByRelaseDateDESC")
    public DataResult<List<JobAdvertisement>> getALlSortedByRelaseDateDESC() {
        return iJobAdvertisementService.getALlSortedByRelaseDateDESC();
    }

    @GetMapping("/getAllByActiveTrueAndEmployerEmployer_Id")
    public DataResult<List<JobAdvertisement>> getAllByActiveTrueAndEmployerEmployer_Id(@RequestParam Integer id) {
        return iJobAdvertisementService.getAllByActiveTrueAndEmployerEmployer_Id(id);
    }

    @PostMapping("/setActivity")
    public Result setActivity(Integer id, boolean bool) {
        return iJobAdvertisementService.setActivity(id, bool);
    }


    @GetMapping("/getAdvertisementWithCompanyAndPositionDetails")
    public DataResult<List<AdvertisementWithCompanyAndPositionDto>> getAdvertisementWithCompanyAndPositionDetails(@RequestParam int employerId) {
        return iJobAdvertisementService.getAdvertisementWithCompanyAndPositionDetails(employerId);
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
