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
    public ResponseEntity addInformRepairDetails(@RequestBody Map<String,String> map){
        try {
            InformRepairDetails informRepairDetails = informRepairDetailsService.saveInformRepairDetails(map);
            return new ResponseEntity<>(informRepairDetails, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateInformRepairDetails(@RequestBody Map<String,String> map){
        try {
            InformRepairDetails informRepairDetails = informRepairDetailsService.updateInformRepairDetails(map);
            return new ResponseEntity<>(informRepairDetails, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
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
}
