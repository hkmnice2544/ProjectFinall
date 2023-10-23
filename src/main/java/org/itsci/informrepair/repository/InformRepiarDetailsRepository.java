package org.itsci.informrepair.repository;
import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.InformRepairDetailsID;
import org.springframework.data.jpa.repository.Query;

import org.itsci.informrepair.model.InformRepairDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InformRepiarDetailsRepository extends JpaRepository<InformRepairDetails,InformRepairDetailsID> {
//    Optional<Object> findById(InformRepairDetailsID id);
    Optional<InformRepairDetails> findById(InformRepairDetailsID id);


//    @Query("SELECT IR.informrepair_id, SUM(IRD.amount) AS TotalAmount, IR.status AS Status, IR.informdate AS InformDate FROM InformRepairDetails IRD INNER JOIN IRD.informRepair IR GROUP BY IR.informrepair_id, IR.status, IR.informdate")
//    List<Object[]> findAllDetailsWithSumAndDate();
//
    @Query(value = "SELECT distinct* FROM inform_repairdetails where informrepair_id = :informrepair_id", nativeQuery = true)
    List<InformRepairDetails> findAllDetailsByInformRepairId(int informrepair_id);

//
//    @Query("SELECT d FROM InformRepairDetails d WHERE d.informRepair = :informRepair")
//    List<InformRepairDetails> findByInformRepair(@Param("informRepair") InformRepair informRepair);
//
    @Query(value = "select * from inform_repairdetails where informrepair_id = :informrepair_id", nativeQuery = true)
    List<InformRepairDetails> ViewListInformDetails(int informrepair_id);


    @Query(value = "select *from inform_repairdetails group by informrepair_id", nativeQuery = true)
    List<InformRepairDetails> ListInformDetailsGroupbyinformrepair_id();




}