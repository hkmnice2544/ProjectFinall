package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.Building;
import org.itsci.informrepair.model.Room;
import org.itsci.informrepair.service.BuildingService;
import org.itsci.informrepair.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rooms", produces = "application/json; charset=UTF-8")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping("/test")
    public String test() {
        return "hi";
    }

    @PostMapping("/listAllDistinctRoomNames")
    public ResponseEntity<List<String>> getAllDistinctRoomNames() {
        try {
            List<String> distinctRoomNames = roomService.getAllDistinctRoomNames();
            return new ResponseEntity<>(distinctRoomNames, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/listAllDistinctRoomfloor")
    public ResponseEntity<List<String>> getAllDistinctRoomfloor() {
        try {
            List<String> distinctRoomfloor = roomService.getAllDistinctRoomfloor();
            return new ResponseEntity<>(distinctRoomfloor, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listAllDistinctRoomposition")
    public ResponseEntity<List<String>> getAllDistinctRoomposition() {
        try {
            List<String> distinctRoomposition = roomService.getAllDistinctRoomposition();
            return new ResponseEntity<>(distinctRoomposition, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/floor/{building_id}")
    public ResponseEntity findfloorByIdbuilding_id(@PathVariable Integer building_id){
        try {
            List<String> floor = roomService.findfloorByIdbuilding_id(building_id);
            return new ResponseEntity<>(floor, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/position/{building_id}/{floor}")
    public ResponseEntity findpositionByIdbuilding_id(@PathVariable Integer building_id, @PathVariable String floor) {
        try {
            List<String> position = roomService.findpositionByIdbuilding_id(building_id,floor);
            return new ResponseEntity<>(position, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/roomname/{building_id}/{floor}/{position}")
    public ResponseEntity findroomnameByIdbuilding_id(@PathVariable Integer building_id, @PathVariable String floor,@PathVariable String position) {
        try {
            List<String> roomname = roomService.findroomnameByIdbuilding_id(building_id,floor,position);
            return new ResponseEntity<>(roomname, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findroom_idByIdByAll/{building_id}/{floor}/{position}/{roomname}")
    public ResponseEntity findroom_idByIdByAll(@PathVariable Integer building_id, @PathVariable String floor,@PathVariable String position,@PathVariable String roomname) {
        try {
            List<String> room_id = roomService.findroom_idByIdByAll(building_id,floor,position,roomname);
            return new ResponseEntity<>(room_id, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/findequipment_idByIdByroom_id/{room_id}")
    public ResponseEntity  findequipment_idByIdByroom_id(@PathVariable Integer room_id) {
        try {
            List<String> equipment_id = roomService. findequipment_idByIdByroom_id(room_id);
            return new ResponseEntity<>(equipment_id, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/findequipmentnameByIdByequipment_id/{equipment_id}")
    public ResponseEntity  findequipmentnameByIdByequipment_id(@PathVariable Integer equipment_id) {
        try {
            List<String> equipmentname = roomService. findequipmentnameByIdByequipment_id(equipment_id);
            return new ResponseEntity<>(equipmentname, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findlistRoomByIdBybuilding_id/{building_id}/{roomtype}")
    public ResponseEntity  findlistRoomByIdBybuilding_id(@PathVariable Integer building_id,@PathVariable String roomtype) {
        try {
            List<Room> room = roomService. findlistRoomByIdBybuilding_id(building_id,roomtype);
            return new ResponseEntity<>(room, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
