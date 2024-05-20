package com.jiat.web.servlet;

import com.zaviron.ejb.remote.TrackCargo;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tracking")
public class TrackingServlet extends HttpServlet {
    @EJB(lookup = "java:global/ear-1.0/com.zaviron-web-1.0/TrackCargoImpl")
    private TrackCargo trackCargo;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String tracking = trackCargo.cargoTracking(Long.valueOf(req.getParameter("tracking")));
        resp.setContentType("text/plain");


        PrintWriter out = resp.getWriter();
        out.println(tracking);
        out.close();


    }
}
