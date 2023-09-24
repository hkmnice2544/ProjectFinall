package org.itsci.informrepair.model;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();  // ใช้ mkdirs() เพื่อสร้างโฟลเดอร์แม้ว่า parent directory ยังไม่มีอยู่
        }

        // สร้างไฟล์ในโฟลเดอร์ uploadDir
        File file = new File(uploadDir + File.separator + fileName);

        // บันทึกไฟล์ลงในโฟลเดอร์
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(multipartFile.getBytes());
        }
    }
}