package org.itsci.informrepair.controller;

import jakarta.persistence.EntityNotFoundException;
import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.FileUploadUtil;
import org.itsci.informrepair.model.InformRepair;

import org.itsci.informrepair.model.Review;
import org.itsci.informrepair.service.InformRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @PostMapping("/addInformRepair")
    public ResponseEntity addInformRepair(@RequestBody Map<String,String> map){
        try {
            InformRepair informRepair = informRepairService.saveInformRepair(map);
            return new ResponseEntity<>(informRepair, HttpStatus.OK);

        }catch (Exception e){e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PostMapping("/addRoomEquipmentInform")
//    public ResponseEntity<?> addRoomEquipmentInform(@RequestBody Map<String, String> map) {
//        try {
//            InformRepair informRepair = informRepairService.saveRoomEquipment(map);
//            return new ResponseEntity<>(informRepair, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Failed to save room equipment data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }


//saveRoomEquipment
//

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

    @PostMapping("/review")
    public ResponseEntity<List<InformRepair>> listNotReviewInformRepair() {
        try {
            List<InformRepair> informRepairs = informRepairService.getNotReviewInformRepairs();
            return new ResponseEntity<>(informRepairs, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/amount/{informrepair_id}")
//    public ResponseEntity findSumamountById(@PathVariable Integer informrepair_id){
//        try {
//            int amount = informRepairService.findSumamountById(informrepair_id);
//            return new ResponseEntity<>(amount, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/findInformDetailIDById/{informrepair_id}")
//    public ResponseEntity findInformDetailIDById(@PathVariable Integer informrepair_id){
//        try {
//            int amount = informRepairService.findInformDetailIDById(informrepair_id);
//            return new ResponseEntity<>(amount, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @PostMapping("/getEquipmentFromInformRepair/{informrepair_id}")
//    public ResponseEntity<?> getEquipmentFromInformRepair(@PathVariable Integer informrepair_id) {
//        Equipment equipment = (Equipment) informRepairService.getEquipmentFromInformRepair(informrepair_id);
//        if (equipment != null) {
//            return ResponseEntity.ok(equipment);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }



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
//
//    @PostMapping("/getEquipmentFromInformRepair/{informrepair_id}")
//    public ResponseEntity<?> getEquipmentFromInformRepair(@PathVariable Integer informrepair_id) {
//        Equipment equipment = (Equipment) informRepairService.getEquipmentFromInformRepair(informrepair_id);
//        if (equipment != null) {
//            return ResponseEntity.ok(equipment);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//

//    @PostMapping("/ViewListByinformrepair_id/{informrepair_id}")
//    public ResponseEntity ViewListByinformrepair_id(@PathVariable Integer informrepair_id){
//        try {
//            List<InformRepair> ViewListByinformrepair_id = informRepairService.ViewListByinformrepair_id(informrepair_id);
//            return new ResponseEntity<>(ViewListByinformrepair_id, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String uploadDir = "C:\\Users\\HKMGF\\OneDrive - Maejo university\\Desktop\\New folder (3)\\flutterr\\images\\InformRepairs Pictures";
            String fileName = file.getOriginalFilename();

            FileUploadUtil.saveFile(uploadDir, fileName, file);

            return new ResponseEntity<>("ไฟล์ถูกอัพโหลดและบันทึกเรียบร้อย", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("เกิดข้อผิดพลาดในการอัพโหลดและบันทึกไฟล์", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    private final String imageDirectory = "C:\\Users\\HKMGF\\OneDrive - Maejo university\\Desktop\\New folder (3)\\flutterr\\images\\InformRepairs Pictures";

    @RequestMapping("/{filePath}")
    public byte[] downloadImage (@PathVariable("filePath") String filePath) throws IOException {
        byte[] image = Files.readAllBytes(informRepairService.downloadImage(filePath));
        return image;
    }

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

    @RequestMapping("/uploadimg")
    public ResponseEntity uploadImage (@RequestParam("image") MultipartFile file) throws IllegalStateException, IOException {
        try {
            System.out.println("ori : " + file.getOriginalFilename());
            String filePath = informRepairService.uploadImage(file);
            return new ResponseEntity<>(filePath, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
