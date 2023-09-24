package org.itsci.informrepair.model;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // รับชื่อไฟล์รูปภาพจาก URL
        String imagePath = request.getPathInfo().substring(1); // เอาออก /image/
        Path imageFilePath = Paths.get("C:\\Users\\HKMGF\\IdeaProjects\\ProjectFinall\\src\\main\\java\\org\\itsci\\informrepair\\pictrues", imagePath); // ระบุโฟลเดอร์ที่เก็บรูปภาพ

        // เปิดไฟล์รูปภาพและส่งไปยังเว็บไซต์ผู้ใช้
        try (InputStream imageStream = Files.newInputStream(imageFilePath)) {
            response.setContentType(getServletContext().getMimeType(imagePath));
            response.setContentLength((int) Files.size(imageFilePath));
            Files.copy((Path) imageStream, response.getOutputStream());
        }
    }
}