package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.Room;
import org.itsci.informrepair.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class EquipmentServicelmpl implements EquipmentService{

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getRoomEquipments() {
        return null;
    }

    @Override
    public Equipment getEquipmentById(Integer equipment_id) {

        return equipmentRepository.getReferenceById(equipment_id);
    }

    @Override
    public Equipment saveEquipment(Map<String, String> map) {
        return null;
    }

    @Override
    public Equipment updateEquipment(Map<String, String> map) {
        return null;
    }

    @Override
    public Equipment deleteEquipment(Integer equipment_id) {
        return null;
    }



//    public Set<Room> getRoomDoesNotHaveEquipment(Integer equipment_id) {
//        Equipment equipment = equipmentRepository.findById(equipment_id).orElse(null);
//
//        if (equipment == null) {
//            return new HashSet<>(); // Equipment not found, return empty set
//        }
//
//        return equipment.getRooms();
//    }

    public Set<Room> getRoomDoesNotHaveEquipment(Integer equipment_id) {
        Equipment equipment = equipmentRepository.getReferenceById(equipment_id);
        if (equipment == null) {
            return new HashSet<>(); // Equipment not found, return empty set
        }
        return equipment.getRooms();
    }













}
