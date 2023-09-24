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

    public Inform_pictures getInformPicturesById(Integer informpicturesId) {
        // ดึงข้อมูลจาก inform_picturesRepository ตรง ๆ โดยใช้ ID
        return inform_picturesRepository.findById(informpicturesId).orElse(null);
    }


    public Inform_pictures saveInformPicture(Inform_pictures informPictures) {
        long nextId = inform_picturesRepository.count() + 1;
        Integer informpictures_id = generateInformRepairDetailsId(nextId);
        informPictures.setInformpictures_id(informpictures_id);

        // บันทึกข้อมูลรูปภาพลงในฐานข้อมูล
        return inform_picturesRepository.save(informPictures);
    }

    public Inform_pictures updateInformPicture(Integer informpictures_id, Inform_pictures updatedInformPicture) {
        // ค้นหารูปภาพที่ต้องการแก้ไขจากฐานข้อมูล
        Inform_pictures existingInformPicture = inform_picturesRepository.findById(informpictures_id).orElse(null);

        if (existingInformPicture != null) {
            // ทำการอัปเดตข้อมูลรูปภาพที่ต้องการแก้ไข
            existingInformPicture.setPictureUrl(updatedInformPicture.getPictureUrl());

            // บันทึกการเปลี่ยนแปลงลงในฐานข้อมูล
            return inform_picturesRepository.save(existingInformPicture);
        } else {
            // หากไม่พบรูปภาพที่ต้องการแก้ไข
            return null;
        }
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

    public List<Inform_pictures> updateInformPictures(List<Inform_pictures> informPicturesList) {
        List<Inform_pictures> updatedInformPictures = new ArrayList<>();

        for (Inform_pictures informPictures : informPicturesList) {
            // ตรวจสอบว่ารูปภาพที่ต้องการอัปเดตมีอยู่ในฐานข้อมูลหรือไม่
            Inform_pictures existingInformPicture = inform_picturesRepository.findById(informPictures.getInformpictures_id()).orElse(null);

            if (existingInformPicture != null) {
                // แก้ไขข้อมูลรูปภาพ
                existingInformPicture.setPictureUrl(informPictures.getPictureUrl());

                // บันทึกข้อมูลรูปภาพที่อัปเดตลงในฐานข้อมูล
                updatedInformPictures.add(inform_picturesRepository.save(existingInformPicture));
            }
        }

        return updatedInformPictures;
    }

    public List<Inform_pictures> deleteInformPictures(List<Inform_pictures> informPicturesList) {
        List<Inform_pictures> deletedInformPictures = new ArrayList<>();

        for (Inform_pictures informPictures : informPicturesList) {
            // ตรวจสอบว่ารูปภาพที่ต้องการลบมีอยู่ในฐานข้อมูลหรือไม่
            Inform_pictures existingInformPicture = inform_picturesRepository.findById(informPictures.getInformpictures_id()).orElse(null);

            if (existingInformPicture != null) {
                // ลบรูปภาพ
                inform_picturesRepository.delete(existingInformPicture);
                deletedInformPictures.add(existingInformPicture);
            }
        }

        return deletedInformPictures;
    }




    public Integer generateInformRepairDetailsId(long nextId) {
        int result = (int) nextId;
        result = 1000 + result;
        return result;
    }


}



