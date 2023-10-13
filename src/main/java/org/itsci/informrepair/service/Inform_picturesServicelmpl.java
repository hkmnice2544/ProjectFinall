package org.itsci.informrepair.service;

import org.itsci.informrepair.model.*;
import org.itsci.informrepair.repository.InformRepairRepository;
import org.itsci.informrepair.repository.InformRepiarDetailsRepository;
import org.itsci.informrepair.repository.Inform_picturesRepository;
import org.itsci.informrepair.repository.RoomEquipmentRepository;
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

    @Autowired
    private InformRepiarDetailsRepository informRepiarDetailsRepository;

    @Autowired
    private RoomEquipmentRepository roomEquipmentRepository;

    @Override
    public List<Inform_pictures> ListInformPictures() {
        return inform_picturesRepository.findAll();
    }

    public Inform_pictures getInformPicturesById(Integer informpicturesId) {
        // ดึงข้อมูลจาก inform_picturesRepository ตรง ๆ โดยใช้ ID
        return inform_picturesRepository.findById(informpicturesId).orElse(null);
    }

    public List<Inform_pictures> savedsaveInform_pictures(List<Map<String, Object>> requestDataList) {
        List<Inform_pictures> savedInformPictures = new ArrayList<>();

        for (Map<String, Object> requestData : requestDataList) {
            List<Map<String, String>> picturesList = (List<Map<String, String>>) requestData.get("informPicturesList");
            Integer equipment_id = Integer.parseInt(requestData.get("equipment_id").toString());
            Integer room_id = Integer.parseInt(requestData.get("room_id").toString());
            Integer informrepair_id = Integer.parseInt(requestData.get("informrepair_id").toString());

            for (Map<String, String> pictureData : picturesList) {
                Inform_pictures informPictures = new Inform_pictures();
                long nextId = inform_picturesRepository.count() + 1;
                Integer informPicturesId = generateInformPicturesId(nextId);
                informPictures.setInformpictures_id(informPicturesId);
                informPictures.setPictureUrl(pictureData.get("pictureUrl"));

                // สร้าง InformRepairDetails
                InformRepairDetailsID informRepairDetailsID = new InformRepairDetailsID(equipment_id, room_id, informrepair_id);
                InformRepairDetails informRepairDetails = new InformRepairDetails();
                informRepairDetails.setId(informRepairDetailsID);

                // เชื่อมโยง Inform_pictures กับ InformRepairDetails
                informPictures.setInformRepairDetails(informRepairDetails);

                // บันทึกข้อมูลรูปภาพลงในฐานข้อมูลและเก็บใน savedInformPictures
                savedInformPictures.add(inform_picturesRepository.save(informPictures));
            }
        }

        return savedInformPictures;
    }










    //    public Inform_pictures updateInformPicture(Integer informpictures_id, Inform_pictures updatedInformPicture) {
//        // ค้นหารูปภาพที่ต้องการแก้ไขจากฐานข้อมูล
//        Inform_pictures existingInformPicture = inform_picturesRepository.findById(informpictures_id).orElse(null);
//
//        if (existingInformPicture != null) {
//            // ทำการอัปเดตข้อมูลรูปภาพที่ต้องการแก้ไข
//            existingInformPicture.setPictureUrl(updatedInformPicture.getPictureUrl());
//
//            // บันทึกการเปลี่ยนแปลงลงในฐานข้อมูล
//            return inform_picturesRepository.save(existingInformPicture);
//        } else {
//            // หากไม่พบรูปภาพที่ต้องการแก้ไข
//            return null;
//        }
//    }
//
//    public List<Inform_pictures> saveInformPictures(List<Inform_pictures> informPicturesList, Map<String, String> map) {
//        List<Inform_pictures> savedInformPictures = new ArrayList();
//
//        for (Inform_pictures informPictures : informPicturesList) {
//            long nextId = inform_picturesRepository.count() + 1;
//            Integer Inform_pictures_id = generateInformPicturesId(nextId);
//            // สร้าง InformRepairDetails
//            Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
//            Integer room_id = Integer.parseInt(map.get("room_id"));
//            Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
//            InformRepairDetailsID informRepairDetailsID = new InformRepairDetailsID(equipment_id, room_id, informrepair_id);
//
//            InformRepairDetails informRepairDetails = new InformRepairDetails();
//            informRepairDetails.setId(informRepairDetailsID);
//            String pictureUrl = map.get("pictureUrl");
//
//            // เชื่อมโยง Inform_pictures กับ InformRepairDetails
//            informPictures.setInformRepairDetails(informRepairDetails);
//            informPictures.setPictureUrl(pictureUrl);
//            informPictures.setInformpictures_id(Inform_pictures_id);
//
//            // บันทึกข้อมูลรูปภาพลงในฐานข้อมูลและเก็บใน savedInformPictures
//            savedInformPictures.add(inform_picturesRepository.save(informPictures));
//        }
//
//        return savedInformPictures;
//    }



    //
//    public List<Inform_pictures> updateInformPictures(List<Inform_pictures> informPicturesList) {
//        List<Inform_pictures> updatedInformPictures = new ArrayList<>();
//
//        for (Inform_pictures informPictures : informPicturesList) {
//            // ตรวจสอบว่ารูปภาพที่ต้องการอัปเดตมีอยู่ในฐานข้อมูลหรือไม่
//            Inform_pictures existingInformPicture = inform_picturesRepository.findById(informPictures.getInformpictures_id()).orElse(null);
//
//            if (existingInformPicture != null) {
//                // แก้ไขข้อมูลรูปภาพ
//                existingInformPicture.setPictureUrl(informPictures.getPictureUrl());
//
//                // บันทึกข้อมูลรูปภาพที่อัปเดตลงในฐานข้อมูล
//                updatedInformPictures.add(inform_picturesRepository.save(existingInformPicture));
//            }
//        }
//
//        return updatedInformPictures;
//    }
//
//    public List<Inform_pictures> deleteInformPictures(List<Inform_pictures> informPicturesList) {
//        List<Inform_pictures> deletedInformPictures = new ArrayList<>();
//
//        for (Inform_pictures informPictures : informPicturesList) {
//            // ตรวจสอบว่ารูปภาพที่ต้องการลบมีอยู่ในฐานข้อมูลหรือไม่
//            Inform_pictures existingInformPicture = inform_picturesRepository.findById(informPictures.getInformpictures_id()).orElse(null);
//
//            if (existingInformPicture != null) {
//                // ลบรูปภาพ
//                inform_picturesRepository.delete(existingInformPicture);
//                deletedInformPictures.add(existingInformPicture);
//            }
//        }
//
//        return deletedInformPictures;
//    }
//
//
//
//
    public Integer generateInformPicturesId(long nextId) {
        int result = (int) nextId;
        result = 1000 + result;
        return result;
    }


}



