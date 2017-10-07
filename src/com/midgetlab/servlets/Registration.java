package com.midgetlab.servlets;

import com.midgetlab.User;
import com.midgetlab.db.DBWorker;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Registration")
public class Registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBWorker dbWorker = new DBWorker();
        User userCheck = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String secondName = request.getParameter("secondname");
        String age = request.getParameter("age");

        String res = "";
        if(userCheck.UserCheck(username)){
            res = "\"" + username + "\",";
            if(userCheck.UserCheck(password)){
                res += "\"" + password + "\",";
                if (userCheck.UserCheck(firstName)){
                    res += "\"" + firstName + "\",";
                    if(userCheck.UserCheck(secondName)){
                        res += "\"" + secondName + "\",";
                    } else return;
                } else return;
            } else return;
        } else return;

        res += "\"" + age + "\"";
        System.out.println(res);

        String query = "insert into users (username, password, firstname, secondname, age) values (" + res + ");";
        System.out.println(query);
        try {
            Statement statement = dbWorker.getConnection().createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        request.setAttribute("status", "Регистрация прошла успешно!");
        request.getRequestDispatcher("grac.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
