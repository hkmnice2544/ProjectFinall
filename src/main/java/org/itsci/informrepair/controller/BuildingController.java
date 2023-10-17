package org.itsci.informrepair.controller;


import org.itsci.informrepair.model.Building;
import org.itsci.informrepair.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/test")
    public String test() {
        return "hi";
    }

    @PostMapping("/getbuildings/{building_id}")
    public ResponseEntity<?> getBuildingById(@PathVariable Integer building_id) {
        try {
            Building building = buildingService.getBuildingById(building_id);
            return ResponseEntity.ok(building);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<Building>> getAllBuilding() {
        try {
            List<Building> building = buildingService.getAllBuilding();
            return new ResponseEntity<>(building, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
