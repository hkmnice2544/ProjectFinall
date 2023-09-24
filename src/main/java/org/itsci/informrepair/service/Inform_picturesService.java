package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Inform_pictures;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface Inform_picturesService {

    Inform_pictures saveInformPicture(Inform_pictures informPictures) ;
//    List<Inform_pictures> saveInform_pictures(List<String> pictureUrls, int informRepairId);
//

}
