package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
