package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Inform_pictures;

import java.util.List;

public interface Inform_picturesService {
    List<Inform_pictures> saveInform_pictures(List<String> pictureUrls, int informRepairId);


}
