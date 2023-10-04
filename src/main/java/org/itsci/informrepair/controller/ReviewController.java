//package org.itsci.informrepair.controller;
//
//import org.itsci.informrepair.model.InformRepair;
//import org.itsci.informrepair.model.Reportrepair;
//import org.itsci.informrepair.model.Review;
//import org.itsci.informrepair.service.InformRepairService;
//import org.itsci.informrepair.service.ReviewService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/reviews")
//public class ReviewController {
//    @Autowired
//    private ReviewService reviewService;
//
////    @RequestMapping("/test")
////    public String test() {
////        return "hi";
////    }
////
//    @PostMapping("/add")
//    public ResponseEntity addReview(@RequestBody Map<String,String> map){
//        try {
//            Review review = reviewService.saveReview(map);
//            return new ResponseEntity<>(review, HttpStatus.OK);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<List<Review>> listReview() {
//        try {
//            List<Review> reviews = reviewService.getAllReviews();
//            return new ResponseEntity<>(reviews, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @PostMapping("/get/{review_id}")
//    public ResponseEntity<?> getReportrepairById(@PathVariable Integer review_id) {
//        try {
//            Review reviews = reviewService.getReviewById(review_id);
//            return ResponseEntity.ok(reviews);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
