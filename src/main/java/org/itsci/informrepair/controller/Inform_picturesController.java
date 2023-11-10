//package org.itsci.informrepair.controller;
//
//import org.itsci.informrepair.model.FileUploadUtil;
//import org.itsci.informrepair.service.Inform_picturesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/inform_pictures")
//public class Inform_picturesController {
//
//    @Autowired
//    private Inform_picturesService inform_picturesService;
//
//    @RequestMapping("/test")
//    public String test() {
//        return "hi";
//    }
//
////    @PostMapping("/all")
////    public ResponseEntity<List<Inform_pictures>> getAllImages() {
////        List<Inform_pictures> images = inform_picturesService.ListInformPictures();
////
////        if (!images.isEmpty()) {
////            return ResponseEntity.ok().body(images);
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    @PostMapping("get/{informpicturesId}")
////    public Inform_pictures getInformPictures(@PathVariable Integer informpicturesId) {
////        return inform_picturesService.getInformPicturesById(informpicturesId);
////    }
////
//
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        try {
//            String uploadDir = "C:\\Users\\HKMGF\\IdeaProjects\\ProjectFinall\\src\\main\\java\\org\\itsci\\informrepair\\InformRepairDetails Pictures";
//            String fileName = file.getOriginalFilename();
//
//            FileUploadUtil.saveFile(uploadDir, fileName, file);
//
//            return new ResponseEntity<>("ไฟล์ถูกอัพโหลดและบันทึกเรียบร้อย", HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("เกิดข้อผิดพลาดในการอัพโหลดและบันทึกไฟล์", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
////    @PostMapping("/addInformPictures")
////    public ResponseEntity<List<Inform_pictures>> saveInformPictures(@RequestBody List<Map<String, Object>> requestDataList) {
////        try {
////            List<Inform_pictures> savedInformPictures = inform_picturesService.savedsaveInform_pictures(requestDataList);
////            return new ResponseEntity<>(savedInformPictures, HttpStatus.OK);
////        } catch (Exception e) {
////            e.printStackTrace();
////            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////
//
//
//
//
//
//    @PostMapping("/deleteMultipleFiles")
//    public ResponseEntity<String> deleteMultipleFiles(@RequestParam("fileNames") List<String> fileNames) {
//        try {
//            String uploadDir = "C:\\Users\\HKMGF\\IdeaProjects\\ProjectFinall\\src\\main\\java\\org\\itsci\\informrepair\\pictrues";
//
//            for (String fileName : fileNames) {
//                File file = new File(uploadDir + File.separator + fileName);
//
//                if (file.exists() && file.delete()) {
//                    System.out.println("ลบไฟล์ " + fileName + " เรียบร้อย");
//                } else {
//                    System.out.println("ไม่สามารถลบไฟล์ " + fileName);
//                }
//            }
//
//            return new ResponseEntity<>("ลบไฟล์เรียบร้อย", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("ข้อผิดพลาด: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PostMapping("/uploadAndSaveData")
//    public ResponseEntity<String> uploadFileAndSaveData(@RequestParam("file") MultipartFile file, @RequestParam("data") String data) {
//        try {
//            String uploadDir = "เส้นทาง/ไป/ยัง/โฟลเดอร์/ที่/คุณ/ต้องการ/บันทึกรูปภาพ";
//            String fileName = file.getOriginalFilename();
//
//            // บันทึกไฟล์ลงในเครื่องเซิร์ฟเวอร์
//            FileUploadUtil.saveFile(uploadDir, fileName, file);
//
//            // ทำอะไรต่อกับข้อมูล (เช่น บันทึกข้อมูลไฟล์ลงในฐานข้อมูล) สามารถทำที่นี่
//
//            return new ResponseEntity<>("ไฟล์ถูกอัพโหลดและข้อมูลถูกบันทึกเรียบร้อย", HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("เกิดข้อผิดพลาดในการอัพโหลดและบันทึกไฟล์", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//
//
//
//
//}
