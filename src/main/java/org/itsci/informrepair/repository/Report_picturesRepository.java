package org.itsci.informrepair.repository;


import org.itsci.informrepair.model.Report_pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Report_picturesRepository extends JpaRepository<Report_pictures,Integer> {

    @Query(value = "select* from report_pictures where report_id = :report_id", nativeQuery = true)
    List<Report_pictures> findByReportpicturesId(int report_id);

}
