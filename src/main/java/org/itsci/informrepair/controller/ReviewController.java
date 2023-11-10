package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.FileUploadUtil;
import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Reportrepair;
import org.itsci.informrepair.model.Review;
import org.itsci.informrepair.service.InformRepairService;
import org.itsci.informrepair.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

//    @RequestMapping("/test")
//    public String test() {
//        return "hi";
//    }
//
    @PostMapping("/add")
    public ResponseEntity addReview(@RequestBody Map<String,String> map){
        try {
            Review review = reviewService.saveReview(map);
            return new ResponseEntity<>(review, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Review>> listReview() {
        try {
            List<Review> reviews = reviewService.getAllReviews();
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/get/{review_id}")
    public ResponseEntity<?> getReportrepairById(@PathVariable Integer review_id) {
        try {
            Review reviews = reviewService.getReviewById(review_id);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
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
