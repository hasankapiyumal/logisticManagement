package com.jiat.web.servlet;

import com.zaviron.ejb.entity.Cargo;
import com.zaviron.ejb.remote.ViewCargo;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewCargo")
public class ViewCargoServlet extends HttpServlet {
    @EJB(lookup = "java:global/ear-1.0/com.zaviron-web-1.0/ViewCargoImpl")
    private ViewCargo viewCargo;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cargo> cargo = viewCargo.getCargo();
        req.setAttribute("cargoList",cargo);
        RequestDispatcher dispatcher = req.getRequestDispatcher("cargo_details.jsp");
        dispatcher.forward(req, resp);
    }
}
