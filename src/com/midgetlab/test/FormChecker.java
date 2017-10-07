package com.midgetlab.test;

import com.midgetlab.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "FormChecker")
public class FormChecker extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(username);
        Boolean check = new User().UserCheck(username);
        if (check){
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
        try (PrintWriter out = response.getWriter()) {
            out.write((check ? "1" : "0"));
        }
    }
}
