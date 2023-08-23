package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Review;
import org.itsci.informrepair.service.InformRepairService;
import org.itsci.informrepair.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/test")
    public String test() {
        return "hi";
    }

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
}
