package com.example.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
    String companyName;
    String webSite;
    String mail;
    String phoneNumber;
    String password;
    String passwordRepeat;
}
