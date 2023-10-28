package com.example.practical_exam.servlet;

import com.example.practical_exam.dao.EmployeeDAO;
import com.example.practical_exam.dao.impl.EmployeeDAOImpl;
import com.example.practical_exam.entity.EmployeeEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "employeeListingServlet", value = "/employees")
public class EmployeeListingServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;

    public void init(){
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EmployeeEntity> employees = employeeDAO.getEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/employeesListing.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get parameter value
        String fullname = req.getParameter("fullname");
        //Convert date-string to java.util.Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String birthdayString = req.getParameter("birthday");
        Date birthday = new Date();
        try {
            birthday = formatter.parse(birthdayString);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date string format");
        }
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
        EmployeeEntity employee = new EmployeeEntity(fullname, birthday, address, position, department);
        employeeDAO.createEmployee(employee);
        this.doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
