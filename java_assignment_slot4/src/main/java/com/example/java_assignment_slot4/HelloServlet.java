package com.example.java_assignment_slot4;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if(password.equals("admin")){
            Cookie loginCookie = new Cookie("username",name);
            loginCookie.setMaxAge(30*60);
            response.addCookie(loginCookie);
            response.sendRedirect("/java_assignment_slot4_war_exploded/upload-servlet");
        }
        else{
            response.sendRedirect("/java_assignment_slot4_war_exploded");
        }
    }

    public void destroy() {
    }
}