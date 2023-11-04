package org.itsci.informrepair.controller;

import jakarta.persistence.EntityNotFoundException;
import org.itsci.informrepair.model.FileUploadUtil;
import org.itsci.informrepair.model.InformRepairDetails;
import org.itsci.informrepair.model.InformRepairDetailsID;
import org.itsci.informrepair.model.Room;
import org.itsci.informrepair.repository.InformRepiarDetailsRepository;
import org.itsci.informrepair.service.InformRepairDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @PostMapping("/ViewListInformDetails/{informrepair_id}")
    public ResponseEntity ViewListInformDetails(@PathVariable Integer informrepair_id){
        try {
            List<InformRepairDetails> viewinformdetails = informRepairDetailsService.ViewListInformDetails(informrepair_id);
            return new ResponseEntity<>(viewinformdetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/ListInformDetailsGroupbyinformrepair_id")
    public ResponseEntity<List<InformRepairDetails>>ListInformDetailsGroupbyinformrepair_id(){
        try {
            List<InformRepairDetails> ListInformDetailsGroupbyinformrepair_id = informRepairDetailsService.ListInformDetailsGroupbyinformrepair_id();
            return new ResponseEntity<>(ListInformDetailsGroupbyinformrepair_id, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/uploadMultiple")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files) {
        try {
            String uploadDir = "C:\\Users\\HKMGF\\OneDrive - Maejo university\\Desktop\\New folder (3)\\flutterr\\images\\InformRepairDetails Pictures";

            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();

                // บันทึกไฟล์ลงในเครื่องเซิร์ฟเวอร์
                FileUploadUtil.saveFile(uploadDir, fileName, file);

                // ทำอะไรต่อกับข้อมูล (เช่น บันทึกข้อมูลไฟล์ลงในฐานข้อมูล) สามารถทำที่นี่
            }

            return new ResponseEntity<>("รูปภาพถูกอัพโหลดและข้อมูลถูกบันทึกเรียบร้อย", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("เกิดข้อผิดพลาดในการอัพโหลดและบันทึกไฟล์", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/findequipment_idByIdByinformrepair_id/{informrepair_id}")
    public ResponseEntity  findequipment_idByIdByinformrepair_id(@PathVariable Integer informrepair_id) {
        try {
            List<String> eqid = informRepairDetailsService. findequipment_idByIdByinformrepair_id(informrepair_id);
            return new ResponseEntity<>(eqid, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/finddetailsByIdByinformrepair_id/{informrepair_id}")
    public ResponseEntity  finddetailsByIdByinformrepair_id(@PathVariable Integer informrepair_id) {
        try {
            List<String> details = informRepairDetailsService. finddetailsByIdByinformrepair_id(informrepair_id);
            return new ResponseEntity<>(details, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findamountByIdByinformrepair_id/{informrepair_id}")
    public ResponseEntity  findamountByIdByinformrepair_id(@PathVariable Integer informrepair_id) {
        try {
            List<String> amount = informRepairDetailsService. findamountByIdByinformrepair_id(informrepair_id);
            return new ResponseEntity<>(amount, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findpicturesByIdByinformrepair_id/{informrepair_id}")
    public ResponseEntity  findpicturesByIdByinformrepair_id(@PathVariable Integer informrepair_id) {
        try {
            List<String> amount = informRepairDetailsService. findpicturesByIdByinformrepair_id(informrepair_id);
            return new ResponseEntity<>(amount, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private final String imageDirectory = "C:\\Users\\HKMGF\\OneDrive - Maejo university\\Desktop\\New folder (3)\\flutterr\\images\\InformRepairDetails Pictures";

    @GetMapping ("/image/{picture_url}")
    public ResponseEntity<Resource> getImage(@PathVariable("picture_url") String imageName) {
        try {
            Path imagePath = Paths.get(imageDirectory).resolve(imageName);
            Resource resource = new UrlResource(imagePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok().body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }



}




