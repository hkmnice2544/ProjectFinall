package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Review;
import org.itsci.informrepair.model.RoomEquipment;
import org.itsci.informrepair.model.RoomEquipmentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomEquipmentRepository extends JpaRepository<RoomEquipment,Integer> {
    Optional<Object> findById(RoomEquipmentId roomEquipmentId);
}
