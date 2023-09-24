package org.itsci.informrepair.service;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Inform_pictures;
import org.itsci.informrepair.repository.InformRepairRepository;
import org.itsci.informrepair.repository.Inform_picturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Inform_picturesServicelmpl implements Inform_picturesService{

    @Autowired
    private Inform_picturesRepository inform_picturesRepository;


    @Autowired
    private InformRepairRepository informRepairRepository;


    public Inform_pictures saveInformPicture(Inform_pictures informPictures) {
        long nextId = inform_picturesRepository.count() + 1;
        Integer informpictures_id = generateInformRepairDetailsId(nextId);
        informPictures.setInformpictures_id(informpictures_id);

        // บันทึกข้อมูลรูปภาพลงในฐานข้อมูล
        return inform_picturesRepository.save(informPictures);
    }

    public List<Inform_pictures> saveInformPictures(List<Inform_pictures> informPicturesList) {
        List<Inform_pictures> savedInformPictures = new ArrayList<>();

        for (Inform_pictures informPictures : informPicturesList) {
            long nextId = inform_picturesRepository.count() + 1;
            Integer informpictures_id = generateInformRepairDetailsId(nextId);
            informPictures.setInformpictures_id(informpictures_id);

            // บันทึกข้อมูลรูปภาพลงในฐานข้อมูลและเก็บใน savedInformPictures
            savedInformPictures.add(inform_picturesRepository.save(informPictures));
        }

        return savedInformPictures;
    }


    public Integer generateInformRepairDetailsId(long nextId) {
        int result = (int) nextId;
        result = 1000 + result;
        return result;
    }


}



