package org.itsci.informrepair.repository;

import jakarta.persistence.EntityManager;
import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.InformRepair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment,Integer> {
}
