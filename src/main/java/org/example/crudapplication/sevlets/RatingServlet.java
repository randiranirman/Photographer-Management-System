package org.example.crudapplication.sevlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/rate")
public class RatingServlet extends HttpServlet {

    private final RatingsFileHandler handler = new RatingsFileHandler()
;
        protected  void doPost(HttpServletRequest  request, HttpServletResponse response) throws IOException{
            String photographerName = request.getParameter("photographerName");
            String ratingStr = request.getParameter("rating");
            if (photographerName == null || ratingStr == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("Missing parameters.");
                return;
            }
            double rating;
            try {
                rating = Double.parseDouble(ratingStr);
                if (rating < 1 || rating > 5) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("Invalid rating.");
                return;
            }

            handler.saveRating(photographerName, rating);

            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"Rating submitted successfully\"}");

        }
}
