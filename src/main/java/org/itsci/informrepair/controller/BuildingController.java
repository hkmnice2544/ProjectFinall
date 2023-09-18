package org.itsci.informrepair.controller;


import org.itsci.informrepair.repository.BuildingRepositort;
import org.itsci.informrepair.service.BuildingService;
import org.itsci.informrepair.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/test")
    public String test() {
        return "hi";
    }
}
