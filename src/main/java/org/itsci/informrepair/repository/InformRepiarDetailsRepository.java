package org.itsci.informrepair.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.InformRepairDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InformRepiarDetailsRepository extends JpaRepository<InformRepairDetails, Integer> {


    @Query("SELECT IR.informrepair_id, SUM(IRD.amount) AS TotalAmount, IR.status AS Status, IR.informdate AS InformDate FROM InformRepairDetails IRD INNER JOIN IRD.informRepair IR GROUP BY IR.informrepair_id, IR.status, IR.informdate")
    List<Object[]> findAllDetailsWithSumAndDate();
}
