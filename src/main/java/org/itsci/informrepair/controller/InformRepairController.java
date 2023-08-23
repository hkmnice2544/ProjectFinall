package org.itsci.informrepair.controller;

import jakarta.persistence.EntityNotFoundException;
import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.service.InformRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


import java.util.*;

@RestController
@RequestMapping(value = "/informrepairs", produces = "application/json; charset=UTF-8")
public class InformRepairController {

    @Autowired
    private InformRepairService informRepairService;
    @RequestMapping("/test")
    public String test() {
        return "hi";
    }

    @PostMapping("/add")
    public ResponseEntity addInformRepair(@RequestBody List<Map<String, String>> mapList) {
        try {
            List<InformRepair> informRepairs = informRepairService.saveInformRepair(mapList);
            return new ResponseEntity<>(informRepairs, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/update")
    public ResponseEntity updateInformRepair(@RequestBody Map<String,String>map){
        try {
            InformRepair informRepair = informRepairService.updateInformRepair(map);
            return new ResponseEntity<>(informRepair, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deleteInformRepair/{informrepair_id}")
    public ResponseEntity<String> deleteInformRepairById(@PathVariable Integer informrepair_id) {
        try {
            InformRepair informRepair = informRepairService.deleteInformRepair(informrepair_id);
            return new ResponseEntity<>("Deleted successfully: " + informRepair, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>("Failed to delete: " + ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete"+informrepair_id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getInformRepair/{informrepair_id}")
    public ResponseEntity<?> getInformRepairById(@PathVariable Integer informrepair_id) {
        try {
            InformRepair informrepair = informRepairService.getInformRepairById(informrepair_id);
            return ResponseEntity.ok(informrepair);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


//
//    @PostMapping("/getInformRepair/{informrepair_id}")
//    public ResponseEntity<Map<String, Object>> getInformRepairById(@PathVariable("informrepair_id") Integer informrepair_id) {
//        try {
//            InformRepair informRepair = informRepairService.getInformRepairById(informrepair_id);
//
//            // สร้าง Map เพื่อแทน JSON ที่จะส่งกลับ
//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "get successfully");
//            response.put("informRepair", informRepair); // หรือคุณอาจจะแปลงเป็น DTO ก่อน
//
//            return ResponseEntity.ok()
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(response);
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("message", "Failed to get: InformRepair with ID " + informrepair_id + " not found");
//
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(errorResponse);
//        }
//    }

    @PostMapping("/list")
    public ResponseEntity<List<InformRepair>> listInformRepair() {
        try {
            List<InformRepair> informRepairs = informRepairService.getAllInformRepairs();
            return new ResponseEntity<>(informRepairs, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



//    @PostMapping("/getEquipmentFromInformRepair/{informrepair_id}")
//    public ResponseEntity<String> getEquipmentFromInformRepair(@PathVariable Integer informrepair_id) {
//        try {
//            InformRepair informRepair = (InformRepair) informRepairService.getEquipmentFromInformRepair(informrepair_id);
//            return new ResponseEntity<>("get successfully"+informRepair, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Failed to get: InformRepair with ID "+informrepair_id+" not found", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/getEquipmentFromInformRepair/{informrepair_id}")
    public ResponseEntity<?> getEquipmentFromInformRepair(@PathVariable Integer informrepair_id) {
        Equipment equipment = (Equipment) informRepairService.getEquipmentFromInformRepair(informrepair_id);
        if (equipment != null) {
            return ResponseEntity.ok(equipment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
