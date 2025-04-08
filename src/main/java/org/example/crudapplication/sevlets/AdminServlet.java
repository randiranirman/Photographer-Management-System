package org.example.crudapplication.sevlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.crudapplication.User;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/getAllUsers")
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ArrayList<User> users =  new ArrayList<User>();






    }
}
