package com.example.hrms.api.controllers;

import com.example.hrms.bussiness.abstracts.ISystemPersonelService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.SystemPersonel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/systempersonels")
public class SystemPersonelController {
    private ISystemPersonelService iSystemPersonelService;

    @Autowired
    public SystemPersonelController(ISystemPersonelService iSystemPersonelService) {
        this.iSystemPersonelService = iSystemPersonelService;
    }

    @GetMapping("/sysetmpersonelss")
    public DataResult<List<SystemPersonel>> getAll()
    {
        return iSystemPersonelService.getAll();
    }


}
