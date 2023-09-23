package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.InformRepairDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformRepiarDetailsRepository extends JpaRepository<InformRepairDetails, Integer> {
}
