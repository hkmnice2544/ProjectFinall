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

    @Query(value = "SELECT " +
            "    IRD.informrepair_id, " +
            "    IR.informdate, " +
            "    R.roomname, " +
            "    R.floor, " +
            "    R.position, " +
            "    B.buildingname " +
            "FROM " +
            "    informrepair_db.inform_repairdetails IRD " +
            "JOIN " +
            "    roomequipment RE ON IRD.room_id = RE.room_id " +
            "JOIN " +
            "    room R ON RE.room_id = R.room_id " +
            "JOIN " +
            "    building B ON R.building_id = B.building_id " +
            "JOIN " +
            "    informrepair IR ON IRD.informrepair_id = IR.informrepair_id " +
            "WHERE " +
            "    IRD.informrepair_id = :informrepair_id " +
            "GROUP BY " +
            "    IRD.informrepair_id, " +
            "    IR.informdate, " +
            "    R.roomname, " +
            "    R.floor, " +
            "    R.position, " +
            "    B.buildingname", nativeQuery = true)
    List<Object[]> findViewInformDetailsById(int informrepair_id);





}
