package org.itsci.informrepair.controller;

import jakarta.persistence.EntityNotFoundException;
import org.itsci.informrepair.model.InformRepairDetails;
import org.itsci.informrepair.model.InformRepairDetailsID;
import org.itsci.informrepair.repository.InformRepiarDetailsRepository;
import org.itsci.informrepair.service.InformRepairDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/informrepairdetails", produces = "application/json; charset=UTF-8")
public class InformRepairDetailsController {
    @Autowired
    private InformRepairDetailsService informRepairDetailsService;
    @Autowired
    private InformRepiarDetailsRepository informRepiarDetailsRepository;

    @RequestMapping("/test")
    public String test() {
        return "hi";
    }

//    @PostMapping("find/{informdetails_id}")
//    public ResponseEntity<?> findInformRepairDetailsById(@PathVariable Integer informdetails_id) {
//        InformRepairDetails informRepairDetails = informRepairDetailsService.getInformRepairDetailsById(informdetails_id);
//        if (informRepairDetails != null) {
//            return ResponseEntity.ok(informRepairDetails);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


    @PostMapping("/list")
    public ResponseEntity<List<InformRepairDetails>> listInformRepairDetails() {
        try {
            List<InformRepairDetails> informRepairDetails = informRepairDetailsService.getAllInformRepairDetails();
            return new ResponseEntity<>(informRepairDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/add")
    public ResponseEntity<List<InformRepairDetails>> addInformRepairDetails(@RequestBody List<Map<String, String>> dataList) {
        try {
            List<InformRepairDetails> informRepairDetailsList = informRepairDetailsService.saveInformRepairDetails(dataList);
            return new ResponseEntity<>(informRepairDetailsList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/update")
    public ResponseEntity<List<InformRepairDetails>> updateInformRepairDetails(@RequestBody List<Map<String, String>> dataList) {
        try {
            List<InformRepairDetails> informRepairDetailsList = informRepairDetailsService.updateInformRepairDetails(dataList);
            return new ResponseEntity<>(informRepairDetailsList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/get/{equipment_id}/{room_id}/{informrepair_id}")
    public ResponseEntity<InformRepairDetails> getInformRepairDetailsById(
            @PathVariable Integer equipment_id,
            @PathVariable Integer room_id,
            @PathVariable Integer informrepair_id
    ) {
        InformRepairDetailsID id = new InformRepairDetailsID(equipment_id, room_id, informrepair_id);
        InformRepairDetails informRepairDetails = informRepairDetailsService.findInformRepairDetailsById(id);

        if (informRepairDetails != null) {
            return ResponseEntity.ok(informRepairDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/deleteInformRepairDetails/{equipment_id}/{room_id}/{informrepair_id}")
    public ResponseEntity<Void> deleteInformRepairDetails(
            @PathVariable Integer equipment_id,
            @PathVariable Integer room_id,
            @PathVariable Integer informrepair_id
    ) {
        InformRepairDetailsID id = new InformRepairDetailsID(equipment_id, room_id, informrepair_id);
        informRepairDetailsService.deleteInformRepairDetails(id);
        return ResponseEntity.noContent().build();
    }





//    @PostMapping("/getInformRepairDetails/{informdetails_id}")
//    public ResponseEntity<?> getInformRepairDetailsById(@PathVariable Integer informdetails_id) {
//        try {
//            InformRepairDetails informRepairDetails = informRepairDetailsService.getInformRepairDetailsById(informdetails_id);
//            return ResponseEntity.ok(informRepairDetails);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.notFound().build();
//        }
//    }



    // เพิ่มเมธอดลบข้อมูล
//    @PostMapping("deleteInformRepairDetails/{informdetails_id}")
//    public ResponseEntity<String> deleteInformRepairById(@PathVariable Integer informdetails_id) {
//        try {
//            InformRepairDetails informRepairDetails = informRepairDetailsService.deleteInformRepairDetailsById(informdetails_id);
//            return new ResponseEntity<>("Deleted successfully: " + informRepairDetails, HttpStatus.OK);
//        } catch (EntityNotFoundException ex) {
//            return new ResponseEntity<>("Failed to delete: " + ex.getMessage(), HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Failed to delete"+informdetails_id, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


//    @PostMapping("/viewinformdetails/{informrepair_id}")
//    public ResponseEntity findSumamountById(@PathVariable Integer informrepair_id){
//        try {
//            List<InformRepairDetails> viewinformdetails = informRepairDetailsService.findViewInformDetailsById(informrepair_id);
//            return new ResponseEntity<>(viewinformdetails, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @PostMapping("/ViewListInformDetails/{informrepair_id}")
//    public ResponseEntity ViewListInformDetails(@PathVariable Integer informrepair_id){
//        try {
//            List<InformRepairDetails> viewinformdetails = informRepairDetailsService.ViewListInformDetails(informrepair_id);
//            return new ResponseEntity<>(viewinformdetails, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



}




