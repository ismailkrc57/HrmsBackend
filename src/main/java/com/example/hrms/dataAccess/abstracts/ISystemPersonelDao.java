package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.SystemPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISystemPersonelDao extends JpaRepository<SystemPersonel,Integer> {
    SystemPersonel getById(Integer id);
}
