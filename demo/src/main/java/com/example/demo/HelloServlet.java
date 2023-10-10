package com.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World 123!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();

        String name = getInitParameter("name");
        if(name != null){
            message = name;
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        for (int i =0; i<cookies.length; i++) {
            out.println("<h1>" + cookies[i].getName() + cookies[i].getValue() + "</h1>");
        }
        out.println("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        String studentPhone = req.getParameter("studentPhone");
        String studentAddress = req.getParameter("studentAddress");
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + studentName + " - " +  studentPhone + " - " + studentAddress + "</h1>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}