package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        Writer out = res.getWriter();
        out.write("<html><body>");
        out.write("<form action='/demo_war/hello-servlet' method='POST'>");
        out.write("<input name='studentName' type='text'/>");
        out.write("<input name='studentPhone' type='text'/>");
        out.write("<input name='studentAddress' type='text'/>");
        out.write("<input type='submit'></input>");
        out.write("</form>");
        out.write("<html><body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    }
}
