package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Reportrepair;
import org.itsci.informrepair.service.InformRepairService;
import org.itsci.informrepair.service.ReportrepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/reportrepairs", produces = "application/json; charset=UTF-8")
public class ReportRepairController {

    @Autowired
    private ReportrepairService reportrepairService;
    @RequestMapping("/test")
    public String test() {
        return "hi";
    }
    @PostMapping("/add")
    public ResponseEntity addReportRepair(@RequestBody Map<String,String> map){
        try {
            Reportrepair reportrepair = reportrepairService.saveReportrepair(map);
            return new ResponseEntity<>(reportrepair, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/list")
    public ResponseEntity listReportRepair(){
        try{

            List<Reportrepair> reportrepairs = reportrepairService.getAllReportrepairs();
            return  new ResponseEntity(reportrepairs,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/get/{report_id}")
    public ResponseEntity<?> getReportrepairById(@PathVariable Integer report_id) {
        try {
            Reportrepair reportrepairs = reportrepairService.getReportrepairById(report_id);
            return ResponseEntity.ok(reportrepairs);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateReportrepair(@RequestBody Map<String,String>map){
        try {
            Reportrepair reportrepairs = reportrepairService.updateReportrepair(map);
            return new ResponseEntity<>(reportrepairs, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
