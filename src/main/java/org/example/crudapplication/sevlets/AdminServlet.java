package org.example.crudapplication.sevlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.crudapplication.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/photographer")
public class AdminServlet extends HttpServlet {
    PhotographerFileHandler handler= new PhotographerFileHandler()
;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ArrayList<User> users =  handler.getAllPhotographers();

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        for (User user : users) {
            out.println("Username: " + user.getUsername() + ", Role: " + user.getRole());
        }

        out.flush();






    }
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws  IOException, ServletException {


        String username  = request.getParameter("username");
         String password = request.getParameter("password");
         String role ="photographer";
         User newPhotographer = new User(username,password,role);
         handler.savePhotographer(newPhotographer);
         response.setStatus(HttpServletResponse.SC_OK);


         response.getWriter().write("photographer added succsesfuly");



    }
    protected  void doDelete(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String username= request.getParameter("username");

        if( username == null ){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("username parameter is required");
            return ;

        }

        boolean deleted = handler.deletePhotographer(username);
        if(deleted){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("photographer deleted succefully");

        }else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Photographer with username '" + username + "' not found");
        }


    }
}
