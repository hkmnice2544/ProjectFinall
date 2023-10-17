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

    @Query(value = "SELECT floor FROM room WHERE building_id = :building_id GROUP BY floor ORDER BY CASE WHEN floor = 'G' THEN 0 ELSE CAST(floor AS SIGNED) END,  floor",nativeQuery = true)
    List<String> findfloorByIdbuilding_id(int building_id);


    @Query(value = "select position from room where building_id = :building_id and floor = :floor group by position",nativeQuery = true)
    List<String> findpositionByIdbuilding_id(int building_id,String floor);
}
