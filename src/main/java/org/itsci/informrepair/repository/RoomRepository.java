package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    @Query("SELECT DISTINCT r.roomname FROM Room r")
    List<String> findAllDistinctRoomNames();

    @Query("SELECT DISTINCT r.floor FROM Room r")
    List<String> findAllDistinctoomfloor();

    @Query("SELECT DISTINCT r.position FROM Room r")
    List<String> findAllDistinctoomposition();
}
