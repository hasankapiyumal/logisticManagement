package com.jiat.web.servlet;

import com.zaviron.ejb.remote.AddCargo;
import com.zaviron.ejb.remote.DeliverCargo;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addCargo")
public class AddCargoServlet extends HttpServlet {
    @EJB(lookup = "java:global/ear-1.0/com.zaviron-web-1.0/AddCargoImpl")
    private AddCargo addCargo;
    @EJB(lookup = "java:global/ear-1.0/com.zaviron-web-1.0/DeliverCargoImpl")
    private DeliverCargo deliverCargo;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentLocation =req.getParameter("currentLocation");
        String destinationLocation=req.getParameter("destinationLocation");
        String details=req.getParameter("details");
        String originLocation=req.getParameter("originLocation");
        String status=req.getParameter("status");
        Long cargo = addCargo.addCargo(currentLocation, originLocation, destinationLocation, status, details);
        deliverCargo.time(cargo);
    }
}
