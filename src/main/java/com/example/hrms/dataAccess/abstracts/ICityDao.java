package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityDao extends JpaRepository<City,Integer> {
}
