package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.Building;
import org.itsci.informrepair.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepositort extends JpaRepository<Building,Integer> {
}

