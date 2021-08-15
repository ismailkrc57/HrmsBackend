package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class Experience {

    @NotNull
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "workplace_name")
    private String workPlaceName;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @Column(name="status")
    private boolean status;


    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
