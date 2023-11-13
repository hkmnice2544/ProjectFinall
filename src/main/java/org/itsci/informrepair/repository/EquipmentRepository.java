package org.itsci.informrepair.repository;

import jakarta.persistence.EntityManager;
import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Report_pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment,Integer> {
    @Query(value = "select * from equipment where room_id = :room_id", nativeQuery = true)
    List<Equipment> findEquipmentByRoomId(int room_id);
}
