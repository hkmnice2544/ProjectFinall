package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.Reportrepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportrepairRepository extends JpaRepository <Reportrepair,Integer> {

}
