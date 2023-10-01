package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.FileUploadUtil;
import org.itsci.informrepair.model.Inform_pictures;
import org.itsci.informrepair.model.Report_pictures;
import org.itsci.informrepair.service.Inform_picturesService;
import org.itsci.informrepair.service.Report_picturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/report_pictures")
public class Report_picturesController {


    @Autowired
    private Report_picturesService reportPicturesService;

    @RequestMapping("/test")
    public String test() {
        return "hi";
    }

    @PostMapping("/addReport_pictures")
    public ResponseEntity saveReport_pictures(@RequestBody List<Report_pictures> Report_picturesList) {
        try {
            List<Report_pictures> saveReport_pictures = reportPicturesService.saveReport_pictures(Report_picturesList);
            return new ResponseEntity<>(saveReport_pictures, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/uploadMultiple")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files) {
        try {
            String uploadDir = "C:\\Users\\HKMGF\\IdeaProjects\\ProjectFinall\\src\\main\\java\\org\\itsci\\informrepair\\pictrues\\Report_Pictures";


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


}
