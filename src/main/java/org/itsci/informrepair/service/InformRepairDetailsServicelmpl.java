package org.itsci.informrepair.service;

import org.itsci.informrepair.model.InformRepairDetails;
import org.itsci.informrepair.repository.EquipmentRepository;
import org.itsci.informrepair.repository.InformRepiarDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformRepairDetailsServicelmpl implements InformRepairDetailsService{
    @Autowired
    private InformRepiarDetailsRepository informRepiarDetailsRepository;

    @Override
    public List<InformRepairDetails> getAllInformRepairDetails() {
        return informRepiarDetailsRepository.findAll();
    }
}
