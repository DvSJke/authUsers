package com.midgetlab.servlets;

import com.midgetlab.db.DBWorker;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name= "Authorization")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
/*        String user = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(user + " " + password);
        if(user.equals("admin")){
            request.setAttribute("status", "Successful Auth! Hello, " + user + " " + password);
        } else {
            request.setAttribute("status", "Bad Auth, try again! Hello, " + user + " " + password);
        }
        request.getRequestDispatcher("grac.jsp").forward(request,response); */
        DBWorker dbWorker = new DBWorker();
        String user = request.getParameter("username").toLowerCase();
        String password = request.getParameter("password");
        String query = "select * from users where username='" + user + "'" + " and password='" + password + "'" ;

        try {

            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                if(resultSet.getString(2).equals(user) && resultSet.getString(3).equals(password)){
                    request.setAttribute("status", "Successful Auth! <br />Session: " + request.getSession().toString() + "<br />Hello, " + resultSet.getString(4) + " " + resultSet.getString(5) + "!");
                    request.getRequestDispatcher("grac.jsp").forward(request,response);
                }
            }
            request.setAttribute("status", "Bad Auth, try again!<br /><a href=\"index.jsp\">Вернуться на главную.");
            request.getRequestDispatcher("grac.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


}
