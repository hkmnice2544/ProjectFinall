package org.itsci.informrepair.service;

import org.itsci.informrepair.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServicelmpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;
    @Override
    public List<String> getAllDistinctRoomNames() {
        return roomRepository.findAllDistinctRoomNames();
    }

    @Override
    public List<String> getAllDistinctRoomfloor() {
        return roomRepository.findAllDistinctoomfloor();
    }

    @Override
    public List<String> getAllDistinctRoomposition() {
        return roomRepository.findAllDistinctoomposition();
    }

    @Override
    public List<String> findfloorByIdbuilding_id(int building_id) {
        return roomRepository.findfloorByIdbuilding_id(building_id);
    }


}
