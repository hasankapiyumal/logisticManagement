package com.jiat.web.servlet;

import com.zaviron.ejb.remote.TimerService;
import com.zaviron.ejb.remote.TrackCargo;
import jakarta.ejb.EJB;
import jakarta.ejb.Timer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tracking")
public class TrackingServlet extends HttpServlet {
        @EJB(lookup = "java:global/ear-1.0/com.zaviron-web-1.0/TrackCargoImpl")
    private TrackCargo trackCargo;
//    @EJB(lookup = "java:global/ear-1.0/com.zaviron-web-1.0/TimerServiceImpl")
//    private TimerService timerService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this method is giving current location
        //   String tracking = trackCargo.cargoTracking(Long.valueOf(req.getParameter("tracking")));
        //  trackCargo.time(Long.valueOf(req.getParameter("tracking")));
      //  timerService.schedule();
        trackCargo.time(1L);
        
        // System.out.println(tracking);
    }
}
