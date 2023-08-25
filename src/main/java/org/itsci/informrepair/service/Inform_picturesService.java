package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.Inform_pictures;

import java.util.List;
import java.util.Map;

public interface Inform_picturesService {
    List<Inform_pictures> saveInform_pictures(List<String> pictureUrls, int informRepairId);


}
