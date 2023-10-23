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



    @Override
    public List<String> findpositionByIdbuilding_id(int building_id,String floor) {
        return roomRepository.findpositionByIdbuilding_id(building_id,floor);
    }


    @Override
    public List<String> findroomnameByIdbuilding_id(int building_id,String floor,String position) {
        return roomRepository.findroomnameByIdbuilding_id(building_id,floor,position);
    }

    @Override
    public List<String> findroom_idByIdByAll(int building_id,String floor,String position,String roomname) {
        return roomRepository.findroom_idByIdByAll(building_id,floor,position,roomname);
    }



}
