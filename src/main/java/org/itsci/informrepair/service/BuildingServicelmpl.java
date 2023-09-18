package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Building;
import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.repository.BuildingRepositort;
import org.itsci.informrepair.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServicelmpl implements BuildingService{
    @Autowired
    private BuildingRepositort buildingRepositort;
    @Override
    public Building getBuildingById(Integer building_id) {
        return buildingRepositort.getReferenceById(building_id);
    }

}
