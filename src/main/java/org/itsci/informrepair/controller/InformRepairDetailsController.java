package org.itsci.informrepair.controller;

import jakarta.persistence.EntityNotFoundException;
import org.itsci.informrepair.model.InformRepairDetails;
import org.itsci.informrepair.service.InformRepairDetailsService;
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

    @PostMapping("find/{informdetails_id}")
    public ResponseEntity<?> findInformRepairDetailsById(@PathVariable Integer informdetails_id) {
        InformRepairDetails informRepairDetails = informRepairDetailsService.getInformRepairDetailsById(informdetails_id);
        if (informRepairDetails != null) {
            return ResponseEntity.ok(informRepairDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
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

    @PostMapping("/update")
    public ResponseEntity updateInformRepairDetails(@RequestBody Map<String, String> map) {
        try {
            InformRepairDetails updatedDetails = (InformRepairDetails) informRepairDetailsService.updateInformRepairDetails(map);
            return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


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
    @PostMapping("deleteInformRepairDetails/{informdetails_id}")
    public ResponseEntity<String> deleteInformRepairById(@PathVariable Integer informdetails_id) {
        try {
            InformRepairDetails informRepairDetails = informRepairDetailsService.deleteInformRepairDetailsById(informdetails_id);
            return new ResponseEntity<>("Deleted successfully: " + informRepairDetails, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>("Failed to delete: " + ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete"+informdetails_id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/allList")
    public List<Map<String, Object>> getAllInformRepairDetails() {
        return informRepairDetailsService.getInformRepairDetails();
    }
    @PostMapping("/viewinformdetails/{informrepair_id}")
    public ResponseEntity findSumamountById(@PathVariable Integer informrepair_id){
        try {
            List<InformRepairDetails> viewinformdetails = informRepairDetailsService.findViewInformDetailsById(informrepair_id);
            return new ResponseEntity<>(viewinformdetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}




