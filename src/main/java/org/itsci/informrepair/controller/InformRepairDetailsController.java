package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.InformRepairDetails;
import org.itsci.informrepair.service.InformRepairDetailsService;
import org.itsci.informrepair.service.InformRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/informrepairdetails", produces = "application/json; charset=UTF-8")
public class InformRepairDetailsController {
    @Autowired
    private InformRepairDetailsService informRepairDetailsService;
    @RequestMapping("/test")
    public String test() {
        return "hi";
    }

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
    public ResponseEntity addInformRepairDetails(@RequestBody List<Map<String, String>> dataList) {
        try {
            List<InformRepairDetails> informRepairDetailsList = informRepairDetailsService.saveInformRepairDetails(dataList);
            return new ResponseEntity<>(informRepairDetailsList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/update")
//    public ResponseEntity updateInformRepairDetails(@RequestBody List<Map<String, String>> dataList) {
//        try {
//            List<InformRepairDetails> informRepairDetailsList = informRepairDetailsService.updateInformRepairDetails(dataList);
//            return new ResponseEntity<>(informRepairDetailsList, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/getInformRepairDetails/{informdetails_id}")
    public ResponseEntity<?> getInformRepairDetailsById(@PathVariable Integer informdetails_id) {
        try {
            InformRepairDetails informRepairDetails = informRepairDetailsService.getInformRepairDetailsById(informdetails_id);
            return ResponseEntity.ok(informRepairDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    // เพิ่มเมธอดลบข้อมูล
//    @DeleteMapping("/{informdetails_id}")
//    public ResponseEntity<String> deleteInformRepairDetails(@PathVariable Integer informdetails_id) {
//        try {
//            informRepairDetailsService.deleteInformRepairDetailsById(informdetails_id);
//            return ResponseEntity.ok("Deleted informRepairDetails with ID: " + informdetails_id);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete informRepairDetails");
//        }
//    }


}
