package com.example.assignment_slot_12.servlet;

import com.example.assignment_slot_12.dao.StudentDAO;
import com.example.assignment_slot_12.dao.impl.StudentDAOImpl;
import com.example.assignment_slot_12.entity.StudentEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listStudentServlet", value = "/list-student")
public class ListStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<StudentEntity> students = studentDAO.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/listStudents.jsp").forward(request, response);
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

    public void destroy() {
    }
}