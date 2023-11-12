package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Room;

import java.util.List;

public interface RoomService {
    List<String> getAllDistinctRoomNames();

    List<String> getAllDistinctRoomfloor();

    List<String> getAllDistinctRoomposition();
    List<String> findfloorByIdbuilding_id(int building_id);

    List<String> findpositionByIdbuilding_id(int building_id,String floor) ;
    List<String> findroomnameByIdbuilding_id(int building_id,String floor,String position);

    List<String> findroom_idByIdByAll(int building_id,String floor,String position,String roomname);

    List<String> findequipment_idByIdByroom_id(int room_id);

    List<String> findequipmentnameByIdByequipment_id(int equipment_id);

    List<Room> findlistRoomByIdBybuilding_id(int building_id, String roomtype);
}
