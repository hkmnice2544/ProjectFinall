//package org.itsci.informrepair.controller;
//
//import org.itsci.informrepair.model.FileUploadUtil;
//import org.itsci.informrepair.model.Inform_pictures;
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
//    @PostMapping("/all")
//    public ResponseEntity<List<Inform_pictures>> getAllImages() {
//        List<Inform_pictures> images = inform_picturesService.ListInformPictures();
//
//        if (!images.isEmpty()) {
//            return ResponseEntity.ok().body(images);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("get/{informpicturesId}")
//    public Inform_pictures getInformPictures(@PathVariable Integer informpicturesId) {
//        return inform_picturesService.getInformPicturesById(informpicturesId);
//    }
//    @PostMapping("/add")
//    public ResponseEntity<Inform_pictures> addInformPicture(@RequestBody Inform_pictures informPictures) {
//        // รับข้อมูลรูปภาพและเรียกใช้ Service เพื่อบันทึกข้อมูล
//        Inform_pictures savedInformPicture = inform_picturesService.saveInformPicture(informPictures);
//        return new ResponseEntity<>(savedInformPicture, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/update/{informpictures_id}")
//    public ResponseEntity<Inform_pictures> updateInformPicture(@PathVariable Integer informpictures_id, @RequestBody Inform_pictures updatedInformPicture) {
//        try {
//            Inform_pictures updatedPicture = inform_picturesService.updateInformPicture(informpictures_id, updatedInformPicture);
//
//            if (updatedPicture != null) {
//                return new ResponseEntity<>(updatedPicture, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        try {
//            String uploadDir = "C:\\Users\\HKMGF\\IdeaProjects\\ProjectFinall\\src\\main\\java\\org\\itsci\\informrepair\\pictrues";
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
//    @PostMapping("/addInformPictures")
//    public ResponseEntity saveInformPictures(@RequestBody List<Inform_pictures> informPicturesList) {
//        try {
//            List<Inform_pictures> savedInformPictures = inform_picturesService.saveInformPictures(informPicturesList);
//            return new ResponseEntity<>(savedInformPictures, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/updateInformPictures")
//    public ResponseEntity<List<Inform_pictures>> updateInformPictures(@RequestBody List<Inform_pictures> informPicturesList) {
//        try {
//            List<Inform_pictures> updatedInformPictures = inform_picturesService.updateInformPictures(informPicturesList);
//            return new ResponseEntity<>(updatedInformPictures, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PostMapping("/delete")
//    public ResponseEntity<List<Inform_pictures>> deleteInformPictures(@RequestBody List<Inform_pictures> informPicturesList) {
//        try {
//            List<Inform_pictures> deletedInformPictures = inform_picturesService.deleteInformPictures(informPicturesList);
//            return new ResponseEntity<>(deletedInformPictures, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//
//
//    @PostMapping("/uploadMultiple")
//    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files) {
//        try {
//            String uploadDir = "C:\\Users\\HKMGF\\IdeaProjects\\ProjectFinall\\src\\main\\java\\org\\itsci\\informrepair\\pictrues";
//
//            for (MultipartFile file : files) {
//                String fileName = file.getOriginalFilename();
//
//                // บันทึกไฟล์ลงในเครื่องเซิร์ฟเวอร์
//                FileUploadUtil.saveFile(uploadDir, fileName, file);
//
//                // ทำอะไรต่อกับข้อมูล (เช่น บันทึกข้อมูลไฟล์ลงในฐานข้อมูล) สามารถทำที่นี่
//            }
//
//            return new ResponseEntity<>("รูปภาพถูกอัพโหลดและข้อมูลถูกบันทึกเรียบร้อย", HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("เกิดข้อผิดพลาดในการอัพโหลดและบันทึกไฟล์", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
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
////
////
////    @PostMapping("/add")
////    public ResponseEntity addInformPictures(@RequestBody Map<String, Object> requestMap) {
////        try {
////            List<String> pictureUrls = (List<String>) requestMap.get("pictureUrls");
////            int informRepairId = (int) requestMap.get("informRepairId");
////
////            List<Inform_pictures> savedPictures = inform_picturesService.saveInform_pictures(pictureUrls, informRepairId);
////            return new ResponseEntity<>(savedPictures, HttpStatus.OK);
////
////        } catch (Exception e) {
////            e.printStackTrace();
////            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////
////
//
//}
