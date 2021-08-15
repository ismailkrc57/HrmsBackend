package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public interface IExperienceDao extends JpaRepository<Experience,Integer> {

    Experience findById(int id);
    List<Experience> getAllByResume_Id(int resumeId);
    List<Experience> getAllByResume_IdOrderByStartDateDesc(int resumeId);

//    @Modifying
//    @Query("update Experience e set e.workPlaceName =: workPlaceName, e.positionName=:positionName,e.startDate=:startDate,e.finishDate=:finishDate where e.id =: id")
//    Result update(@Param("id") int id, @Param("workPlaceName") String workPlaceName, @Param("positionName") String positionName, @Param("startDate") LocalDate startDate,@Param("finishDate") LocalDate finishDate);
}
