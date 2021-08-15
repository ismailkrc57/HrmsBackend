package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhotoDao extends JpaRepository<Photo,Integer> {
    Photo getByResume_Id(int resumeId);
    Photo findById(int id);
}
