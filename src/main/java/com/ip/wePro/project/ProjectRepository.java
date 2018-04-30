package com.ip.wePro.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("select p from Project p where p.owner = :owner and p.statusId = :status")
    List<Project> findAllByStatusIdAndOwner(@Param("owner") int owner, @Param("status") int status);

    @Query("select p from Project p where p.statusId = :status")
    List<Project> findAllByStatusId(@Param("status") int status);

    @Query("select p from Project p where p.owner = :owner and p.statusId in (0,1,2,3)")
    List<Project> findAllByOwner(@Param("owner") int owner);

    @Query("select p from Project p where p.id = :id")
    List<Project> findAllByProjectID(@Param("id") int id);

    @Query("select p from Project p where p.id in :projectIdList")
    List<Project> findAllProjectDetailsBypid(@Param("projectIdList")List<Integer> allProjectIDByStatusIdAndOwnerStatus);

    //@Query("select p from Project p where p.id in (select a from assessment_status as a where )")
    //List<Project> findAllByProjectIDUserID(@Param("id") int id);

    @Query("update Project p set p.statusId = :status where p.id = :id")
    Project updateProjectStatus(@Param("status") int status, @Param("id") int id);

}
