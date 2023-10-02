package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.FileUploadUtil;
import org.itsci.informrepair.model.Report_pictures;
import org.itsci.informrepair.model.Review_pictures;
import org.itsci.informrepair.service.Report_picturesService;
import org.itsci.informrepair.service.Review_picturesService;
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

@RestController
@RequestMapping("/review_pictures")
public class Review_picturesController {
    @Autowired
    private Review_picturesService reviewPicturesService;

    @RequestMapping("/test")
    public String test() {
        return "hi";
    }

    @PostMapping("/addReview_pictures")
    public ResponseEntity saveReview_pictures(@RequestBody List<Review_pictures> Review_picturesList) {
        try {
            List<Review_pictures> saveReview_pictures = reviewPicturesService.saveReview_pictures(Review_picturesList);
            return new ResponseEntity<>(saveReview_pictures, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/uploadMultiple")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files) {
        try {
            String uploadDir = "C:\\Users\\HKMGF\\OneDrive - Maejo university\\Desktop\\New folder (3)\\flutterr\\images\\Review Pictures";


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

    private final String imageDirectory = "C:\\Users\\HKMGF\\OneDrive - Maejo university\\Desktop\\New folder (3)\\flutterr\\images\\Review Pictures";

    @PostMapping("list/{review_id}")
    public ResponseEntity<List<Review_pictures>> getReportPicturesByReportpicturesId(@PathVariable Integer review_id) {
        List<Review_pictures> reviewPicturesList = reviewPicturesService.getReview_picturesByReportpicturesId(review_id);

        if (!reviewPicturesList.isEmpty()) {
            return ResponseEntity.ok().body(reviewPicturesList);
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
