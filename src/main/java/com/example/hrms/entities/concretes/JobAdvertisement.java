package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "job_advertisements")
@NoArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank(message = "please Enter Detail")
    @Column(name = "detail")
    private String detail;


    @NotNull
    @Column(name = "max_salary")
    private int maxSalary;

    @NotNull
    @Column(name = "min_salary")
    private int minSalary;


    @Min(value = 1)
    @NotNull(message = "please enter number of positions")
    @Column(name = "number_of_open_positions")
    private int numberOfOpenPositons;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a date.")
    @Column(name = "deadline")
    private LocalDate deadline;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a date.")
    @Column(name = "relase_date")
    private LocalDate relaseDate;


    @Column(name = "is_active")
    private boolean isActive;

    @JoinColumn(name = "employer_id")
    @ManyToOne()
    private Employer employer;

    @JoinColumn(name = "position_id")
    @ManyToOne()
    private JobPosition jobPosition;

    @JoinColumn(name = "city_id")
    @ManyToOne()
    private City city;
}
