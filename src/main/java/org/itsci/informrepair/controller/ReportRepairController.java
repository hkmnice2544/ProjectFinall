package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Reportrepair;
import org.itsci.informrepair.service.InformRepairService;
import org.itsci.informrepair.service.ReportrepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reportrepairs")
public class ReportRepairController {
//
//    @Autowired
//    private ReportrepairService reportrepairService;
//    @RequestMapping("/test")
//    public String test() {
//        return "hi";
//    }
//    @PostMapping("/add")
//    public ResponseEntity addReportRepair(@RequestBody Map<String,String> map){
//        try {
//            Reportrepair reportrepair = reportrepairService.saveReportrepair(map);
//            return new ResponseEntity<>(reportrepair, HttpStatus.OK);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/list")
//    public ResponseEntity listReportRepair(){
//        try{
//
//            List<Reportrepair> reportrepairs = reportrepairService.getAllReportrepairs();
//            return  new ResponseEntity(reportrepairs,HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//

}
