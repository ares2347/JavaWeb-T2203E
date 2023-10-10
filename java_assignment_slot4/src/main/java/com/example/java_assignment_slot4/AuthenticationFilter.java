package com.example.java_assignment_slot4;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@WebFilter(servletNames = "uploadServlet")
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            Optional<Cookie> username = Arrays.stream(cookies).filter(c -> c.getName().equals("username")).findAny();
            if (username.isEmpty()){
                httpResponse.sendRedirect("/java_assignment_slot4_war_exploded");
            }else{
                chain.doFilter(req, resp);
            }
        }else {
            httpResponse.sendRedirect("/java_assignment_slot4_war_exploded");
        }
    }

    public void destroy() {}
}
