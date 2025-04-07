package org.example.crudapplication.sevlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.crudapplication.Customer;
import org.example.crudapplication.Photographer;
import org.example.crudapplication.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final FileHandler handler = new FileHandler();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response type
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Extract parameters directly (no JSON parsing)
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Simple validation
        if (action == null || username == null || password == null || role == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"error\":\"Missing required fields\"}");
            return;
        }

        System.out.println("Received action: " + action);

        switch (action.toLowerCase()) {
            case "signup":
                handler.appendUser(new User(username, password, role));
                out.println("{\"status\":\"User signed up successfully\"}");
                break;

            case "createphotographer":
                handler.appendUser(new Photographer(username, password));
                out.println("{\"status\":\"Photographer created successfully\"}");
                break;

            case "deletephotographer":
                if (handler.deleteUser(username, "photographer")) {
                    out.println("{\"status\":\"Photographer deleted\"}");
                } else {
                    out.println("{\"error\":\"Photographer not found\"}");
                }
                break;

            case "editphotographer":
                // Add your edit logic here if needed
                out.println("{\"status\":\"Edit functionality not implemented yet\"}");
                break;

            default:
                out.println("{\"error\":\"Unknown action: " + action + "\"}");
                break;
        }
    }
}
