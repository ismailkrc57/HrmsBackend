package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "system_personels")
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class SystemPersonel extends User{

    @Column(name = "user_id")
    private int userId;

    @NotBlank
    @NotBlank(message = "please eneter name")
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank(message = "please eneter surname")
    @Column(name = "surname")
    private  String surname;

}
