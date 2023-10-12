package com.example.java_assignment_slot6.servlet;

import com.example.java_assignment_slot6.dao.StudentDAO;
import com.example.java_assignment_slot6.dao.impl.StudentDAOImpl;
import com.example.java_assignment_slot6.entity.StudentEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "studentListingServlet", value = "/students")
public class StudentListingServlet extends HttpServlet {
    private StudentDAO studentDAO;
    public void init(){
        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //set resp content type
        resp.setContentType("text/html");
        //business logic
        List<StudentEntity> students = studentDAO.getAllStudents();
        //UI rendering
        PrintWriter out = resp.getWriter();
        out.println("<html> <head> <style>html{background-color: white;}table{border: 1px solid black; border-collapse: collapse;}table, th, td{border: 1px solid;}table th{width: 100px; padding: 5px 20px; text-align: center;}table th:last-child{width: 150px;}table td{padding: 2px 5px;}</style> </head> <body>");
        out.println("<h1>Student Listing</h1><br/>");
        out.println("<a href='./students/add'>Add new student</a><br/>");
        out.println("<table> <thead> <tr> <th>Id</th> <th>Name</th> <th>Birth Year</th> <th>Phone Number</th> </tr></thead> <tbody>");
        for (int i= 0; i< students.size(); i++){
            StudentEntity student = students.get(i);
            out.println("<tr><td>"+student.id+"</td><td>"+student.name+"</td><td>"+student.birthyear+"</td><td>"+student.phone+"</td></tr>");
        }
        out.println("</tbody> </table>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer birthyear = Integer.parseInt(req.getParameter("birthyear"));
        String phone = req.getParameter("phone");
        StudentEntity student = new StudentEntity(name, birthyear, phone);
        studentDAO.createStudent(student);
        this.doGet(req, resp);
    }
}
