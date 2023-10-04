//package org.itsci.informrepair.controller;
//
//import org.itsci.informrepair.model.Building;
//import org.itsci.informrepair.model.Room;
//import org.itsci.informrepair.service.BuildingService;
//import org.itsci.informrepair.service.RoomService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/rooms", produces = "application/json; charset=UTF-8")
//public class RoomController {
//
//    @Autowired
//    private RoomService roomService;
//
//    @RequestMapping("/test")
//    public String test() {
//        return "hi";
//    }
//
//    @PostMapping("/listAllDistinctRoomNames")
//    public ResponseEntity<List<String>> getAllDistinctRoomNames() {
//        try {
//            List<String> distinctRoomNames = roomService.getAllDistinctRoomNames();
//            return new ResponseEntity<>(distinctRoomNames, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PostMapping("/listAllDistinctRoomfloor")
//    public ResponseEntity<List<String>> getAllDistinctRoomfloor() {
//        try {
//            List<String> distinctRoomfloor = roomService.getAllDistinctRoomfloor();
//            return new ResponseEntity<>(distinctRoomfloor, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/listAllDistinctRoomposition")
//    public ResponseEntity<List<String>> getAllDistinctRoomposition() {
//        try {
//            List<String> distinctRoomposition = roomService.getAllDistinctRoomposition();
//            return new ResponseEntity<>(distinctRoomposition, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//}
