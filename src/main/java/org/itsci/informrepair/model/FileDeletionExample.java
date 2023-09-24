package org.itsci.informrepair.model;
import java.io.File;


public class FileDeletionExample {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\HKMGF\\IdeaProjects\\ProjectFinall\\src\\main\\java\\org\\itsci\\informrepair\\pictrues";

        // ตรวจสอบว่าโฟลเดอร์มีอยู่หรือไม่
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("โฟลเดอร์ไม่พบ");
            return;
        }

        // ลบไฟล์ทั้งหมดในโฟลเดอร์
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.delete()) {
                    System.out.println("ลบไฟล์ " + file.getName() + " เรียบร้อย");
                } else {
                    System.out.println("ไม่สามารถลบไฟล์ " + file.getName());
                }
            }
        } else {
            System.out.println("ไม่มีไฟล์ในโฟลเดอร์");
        }

        // ลบโฟลเดอร์เปล่าหลังจากลบไฟล์ทั้งหมด (ถ้าต้องการ)
        if (directory.delete()) {
            System.out.println("ลบโฟลเดอร์เรียบร้อย");
        } else {
            System.out.println("ไม่สามารถลบโฟลเดอร์");
        }
    }
}