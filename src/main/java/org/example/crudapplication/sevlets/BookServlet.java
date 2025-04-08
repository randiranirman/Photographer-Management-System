package org.example.crudapplication.sevlets;

import jakarta.json.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.crudapplication.Appointment;
import org.example.crudapplication.Customer;
import org.example.crudapplication.Photographer;
import org.example.crudapplication.Queue;

import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/book")
public class BookServlet extends HttpServlet
{
    private Queue queue = new Queue();
    private final BookFileHandler handler = new BookFileHandler()
;

    protected void doPost(HttpServletResponse response , HttpServletRequest request) throws IOException, ServletException{
        String customerName = request.getParameter("customerName");
        String photographerName = request.getParameter("photographerName");


        if( customerName == null ||  photographerName == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Missing customer or photographer  nam e");
        }
        Customer customer= new Customer(customerName);
        Photographer photographer  = new Photographer(photographerName);
        Appointment appointment = new Appointment(customer,photographer);
        queue.enqueue(appointment);
        handler.saveBooking(customerName,photographerName);
        response.setContentType("text/plain");
        response.getWriter().write("booked successfully");

    }



}
