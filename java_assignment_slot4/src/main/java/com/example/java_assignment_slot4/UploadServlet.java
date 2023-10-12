package com.example.java_assignment_slot4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "uploadServlet", value = "/upload-servlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class UploadServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Upload file here</h1>");
        out.println("<form method='POST' action='/java_assignment_slot4_war_exploded/upload-servlet' enctype='multipart/form-data'>");
        out.println("<input type='file' name='file'/>");
        out.println("<input type='submit' value='Upload'/>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        filePart.write("D:\\temp\\" + fileName);
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Upload file here</h1>");
        out.println("<h1>The file uploaded sucessfully.</h1>");
        out.println("<form method='POST' action='/java_assignment_slot4_war_exploded/upload-servlet' enctype='multipart/form-data'>");
        out.println("<input type='file' name='file'/>");
        out.println("<input type='submit' value='Upload'/>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}