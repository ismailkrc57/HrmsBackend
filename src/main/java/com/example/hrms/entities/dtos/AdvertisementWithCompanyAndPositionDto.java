package com.example.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementWithCompanyAndPositionDto {
    private int id;
    private String companyName;
    private String positionName;
    private int numberOfOpenPositions;
    private LocalDate relaseDate;
    private LocalDate deadline;
}
