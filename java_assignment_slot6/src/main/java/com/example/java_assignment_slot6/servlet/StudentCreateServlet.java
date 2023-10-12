package com.example.java_assignment_slot6.servlet;

import com.example.java_assignment_slot6.entity.StudentEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "studentCreateServlet", value = "/students/add")
public class StudentCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //business logic
        //UI rendering
        PrintWriter out = resp.getWriter();
        out.println("<html> <head> <style>html{background-color: white;}</style> </head><body>");
        out.println("<h1>Add new student</h1><br/>");
        out.println("<h1>Add new student</h1><br/>");
        out.println("<form method='post' action='/java_assignment_slot6_war_exploded/students'>");
        out.println("<input name='name' type='text'/>");
        out.println("<input name='birthyear' type='number' min='1900' max='2099' step='1'/>");
        out.println("<input name='phone' type='tel'/>");
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
