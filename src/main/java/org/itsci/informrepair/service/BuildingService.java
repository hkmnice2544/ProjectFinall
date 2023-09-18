package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Building;
import org.itsci.informrepair.model.Equipment;

import java.util.List;

public interface BuildingService {
    Building getBuildingById(Integer building_id);

    List<Building> getAllBuilding();
}
