package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeWithJobSeekerDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResumeDao extends JpaRepository<Resume,Integer> {

//    @Query("select new com.example.hrms.entities.dtos.ResumeWithJobSeekerDto(j.name,j.surname,r.schools)from JobSeeker j inner join j.resume r inner join r.schools s where r.id=:resumeId and s.resume.id =:resumeId ")
//    ResumeWithJobSeekerDto getResumeWithJobSeeker(int resumeId);
    ResumeWithJobSeekerDto findResumeByJobSeeker_Id(int jobSeekerId);
}
