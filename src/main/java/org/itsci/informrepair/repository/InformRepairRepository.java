package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.InformRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InformRepairRepository extends JpaRepository<InformRepair, Integer> {
    @Query(value = "select sum(amount) from inform_repairdetails where informrepair_id = :informrepair_id",nativeQuery = true)
    int findSumamountById(int informrepair_id);

}
