package org.itsci.informrepair.service;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Inform_pictures;
import org.itsci.informrepair.repository.InformRepairRepository;
import org.itsci.informrepair.repository.Inform_picturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Inform_picturesServicelmpl implements Inform_picturesService{

    @Autowired
    private Inform_picturesRepository inform_picturesRepository;

    @Autowired
    private InformRepairRepository informRepairRepository;

    @Override
    public List<Inform_pictures> saveInform_pictures(List<String> picture_url, int informrepair_id) {
        List<Inform_pictures> savedPictures = new ArrayList<>();

        // ดึง InformRepair จากฐานข้อมูลด้วย informRepairId
        InformRepair informRepair = informRepairRepository.findById(informrepair_id).orElse(null);

        if (informRepair == null) {
            // หากไม่พบ InformRepair ที่ตรงกับ informRepairId ที่กำหนด คุณอาจต้องจัดการข้อผิดพลาดที่นี่
            return savedPictures; // หรือคุณสามารถเลือกเก็บในรายการของ Inform_pictures ที่ไม่สามารถเชื่อมโยงกับ InformRepair ได้
        }

        for (String pictureUrl : picture_url) {
            // สร้าง Inform_pictures
            Inform_pictures picture = new Inform_pictures();
            picture.setPictureUrl(pictureUrl);
            picture.setInformRepair(informRepair); // เชื่อมโยงกับ InformRepair

            // บันทึก Inform_pictures ลงในฐานข้อมูลและเก็บในรายการ savedPictures
            Inform_pictures savedPicture = inform_picturesRepository.save(picture);
            savedPictures.add(savedPicture);
        }

        // คืนค่ารายการของ Inform_pictures ที่ถูกบันทึก
        return savedPictures;
    }



}
