package org.itsci.informrepair.service;

import java.util.List;

public interface RoomService {
    List<String> getAllDistinctRoomNames();

    List<String> getAllDistinctRoomfloor();

    List<String> getAllDistinctRoomposition();
    List<String> findfloorByIdbuilding_id(int building_id);
}
