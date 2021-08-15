package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.AdvertisementWithCompanyAndPositionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    JobAdvertisement getById(Integer id);
    List<JobAdvertisement> getAllByIsActiveTrue();
    List<JobAdvertisement> getAllByIsActiveFalse();
    List<JobAdvertisement> getAllByIsActiveTrueOrderByDeadlineAsc();
    List<JobAdvertisement> getAllByIsActiveTrueOrderByDeadlineDesc();
    List<JobAdvertisement> getAllByIsActiveTrueOrderByRelaseDateAsc();
    List<JobAdvertisement> getAllByIsActiveTrueOrderByRelaseDateDesc();
    List<JobAdvertisement> getAllByIsActiveTrueAndEmployer_Id(Integer id);


    @Query("select new com.example.hrms.entities.dtos.AdvertisementWithCompanyAndPositionDto(a.id,e.companyName,p.positionName,a.numberOfOpenPositons,a.relaseDate,a.deadline) From Employer e inner join  e.jobAdvertisements a inner join  a.jobPosition p where a.isActive = true and e.id =:employerId")
    List<AdvertisementWithCompanyAndPositionDto> getAdvertisementWithCompanyAndPositionDetails(int employerId);


}
