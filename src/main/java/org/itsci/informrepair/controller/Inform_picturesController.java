package org.itsci.informrepair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inform_pictures")
public class Inform_picturesController {

//    @Autowired
//    private Inform_picturesService inform_picturesService;
//
//    @RequestMapping("/test")
//    public String test() {
//        return "hi";
//    }

//
//    @PostMapping("/add")
//    public ResponseEntity addInformPictures(@RequestBody Map<String, Object> requestMap) {
//        try {
//            List<String> pictureUrls = (List<String>) requestMap.get("pictureUrls");
//            int informRepairId = (int) requestMap.get("informRepairId");
//
//            List<Inform_pictures> savedPictures = inform_picturesService.saveInform_pictures(pictureUrls, informRepairId);
//            return new ResponseEntity<>(savedPictures, HttpStatus.OK);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



}
