package com.example.assignment_slot_12.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addStudentServlet", value = "/add-student")
public class AddStudentServlet extends HttpServlet {

    public void init() {
        }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/addStudent.jsp").forward(request, response);
    }

    public void destroy() {
    }
}