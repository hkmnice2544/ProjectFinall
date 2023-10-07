package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.FileUploadUtil;
import org.itsci.informrepair.model.Inform_pictures;
import org.itsci.informrepair.model.Report_pictures;
import org.itsci.informrepair.service.Report_picturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
            String uploadDir = "C:\\Users\\HKMGF\\OneDrive - Maejo university\\Desktop\\New folder (3)\\flutterr\\images\\Report Pictures";


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
    private final String imageDirectory = "C:\\Users\\HKMGF\\OneDrive - Maejo university\\Desktop\\New folder (3)\\flutterr\\images\\Report Pictures";

    @PostMapping("list/{report_id}")
    public ResponseEntity<List<Report_pictures>> getReportPicturesByReportpicturesId(@PathVariable Integer report_id) {
        List<Report_pictures> reportPictures = reportPicturesService.getReportPicturesByReportpicturesId(report_id);

        if (!reportPictures.isEmpty()) {
            return ResponseEntity.ok().body(reportPictures);
        } else {
            return ResponseEntity.notFound().build();
        }
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


}
