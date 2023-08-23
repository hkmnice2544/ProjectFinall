package org.itsci.informrepair.controller;


import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Room;
import org.itsci.informrepair.service.EquipmentService;
import org.itsci.informrepair.service.InformRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/test")
    public String test() {
        return "hi";
    }

//    @PostMapping("/getEquipmentRoom/{equipment_id}")
//    public ResponseEntity<String> getRoomDoesNotHaveEquipment(@PathVariable Integer equipment_id) {
//        try {
//            Map<String, Object> map = new HashMap<>();
//            map.put("equipment_id", equipment_id);
//
//            Set<Room> roomsNotHavingEquipment = equipmentService.getRoomDoesNotHaveEquipment(map);
//
//            // Convert Set<Room> to a format that can be used in the response
//            String responseMessage = "Rooms not having equipment: " + roomsNotHavingEquipment.toString();
//
//            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Failed to get: Equipment with ID " + equipment_id + " not found", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/equipment/{equipment_id}/rooms")
    public ResponseEntity<Set<Room>> getRoomDoesNotHaveEquipment(@PathVariable Integer equipment_id) {
        Set<Room> rooms = equipmentService.getRoomDoesNotHaveEquipment(equipment_id);

        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // No rooms found
        }

        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PostMapping("/getequipment/{equipment_id}")
    public ResponseEntity<String> getEquipmentById(@PathVariable Integer equipment_id) {
        try {
            Equipment equipment = equipmentService.getEquipmentById(equipment_id);
            return new ResponseEntity<>("get successfully"+equipment, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to get: InformRepair with ID "+equipment_id+" not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
