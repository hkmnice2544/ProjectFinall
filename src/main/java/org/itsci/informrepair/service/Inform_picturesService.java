package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Inform_pictures;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface Inform_picturesService {
    List<Inform_pictures> ListInformPictures();


//    Inform_pictures saveInformPicture(Inform_pictures informPictures) ;
//
//    List<Inform_pictures> saveInformPictures(List<Inform_pictures> informPicturesList);
//
//    Inform_pictures updateInformPicture(Integer informpicturesId, Inform_pictures updatedInformPicture);
//
//    List<Inform_pictures> updateInformPictures(List<Inform_pictures> informPicturesList);
//
//    List<Inform_pictures> deleteInformPictures(List<Inform_pictures> informPicturesList);
//
    Inform_pictures getInformPicturesById(Integer informpicturesId);
////    List<Inform_pictures> saveInform_pictures(List<String> pictureUrls, int informRepairId);
//

}
