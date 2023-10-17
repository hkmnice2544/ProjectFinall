package org.itsci.informrepair.service;

import java.util.List;

public interface RoomService {
    List<String> getAllDistinctRoomNames();

    List<String> getAllDistinctRoomfloor();

    List<String> getAllDistinctRoomposition();
    List<String> findfloorByIdbuilding_id(int building_id);

    List<String> findpositionByIdbuilding_id(int building_id,String floor) ;
    List<String> findroomnameByIdbuilding_id(int building_id,String floor,String position);
}
